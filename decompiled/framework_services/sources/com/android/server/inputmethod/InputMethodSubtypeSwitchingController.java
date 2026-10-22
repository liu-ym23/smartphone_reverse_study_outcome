package com.android.server.inputmethod;

import android.content.Context;
import android.os.UserHandle;
import android.text.TextUtils;
import android.util.ArraySet;
import android.util.Printer;
import android.util.Slog;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodSubtype;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
final class InputMethodSubtypeSwitchingController {
    private static final boolean DEBUG = false;
    public static final int MODE_AUTO = 2;
    public static final int MODE_RECENT = 1;
    public static final int MODE_STATIC = 0;
    private static final String TAG = null;
    private RotationList mHardwareRotationList;
    private RotationList mRotationList;
    private DynamicRotationList mSwitchingAwareRotationList;
    private StaticRotationList mSwitchingUnawareRotationList;
    private boolean mUserActionSinceSwitch;

    private static class DynamicRotationList {
        private static final String TAG = null;
        private final List<ImeSubtypeListItem> mImeSubtypeList;
        private final int[] mUsageHistoryOfSubtypeListItemIndex;

        /* JADX INFO: renamed from: -$$Nest$fgetmImeSubtypeList, reason: not valid java name */
        static /* bridge */ /* synthetic */ List m4786$$Nest$fgetmImeSubtypeList(DynamicRotationList r0) {
            return r0.mImeSubtypeList;
        }

        /* synthetic */ DynamicRotationList(List r1, InputMethodSubtypeSwitchingControllerIA r2) {
            this(r1);
        }

        static {
            TAG = DynamicRotationList.class.getSimpleName();
        }

        private DynamicRotationList(List<ImeSubtypeListItem> imeSubtypeListItems) {
            this.mImeSubtypeList = imeSubtypeListItems;
            this.mUsageHistoryOfSubtypeListItemIndex = new int[this.mImeSubtypeList.size()];
            int numSubtypes = this.mImeSubtypeList.size();
            int i = 0;
        L3:
            if (i >= numSubtypes) goto L6;
            this.mUsageHistoryOfSubtypeListItemIndex[i] = i;
            i = i + 1;
            goto L3
        }

        private int getUsageRank(InputMethodInfo imi, InputMethodSubtype subtype) {
            int currentSubtypeIndex = InputMethodSubtypeSwitchingController.m4785$$Nest$smcalculateSubtypeIndex(imi, subtype);
            int numItems = this.mUsageHistoryOfSubtypeListItemIndex.length;
            int usageRank = 0;
        L3:
            if (usageRank >= numItems) goto L10;
            int subtypeListItemIndex = this.mUsageHistoryOfSubtypeListItemIndex[usageRank];
            ImeSubtypeListItem subtypeListItem = this.mImeSubtypeList.get(subtypeListItemIndex);
            if (subtypeListItem.mImi.equals(imi) == false) goto L9;
            if (subtypeListItem.mSubtypeIndex != currentSubtypeIndex) goto L9;
            return usageRank;
        L9:
            usageRank = usageRank + 1;
            goto L3
        L10:
            return -1;
        }

        public void onUserAction(InputMethodInfo imi, InputMethodSubtype subtype) {
            int currentUsageRank = getUsageRank(imi, subtype);
            if (currentUsageRank > 0) goto L5;
            return;
        L5:
            int currentItemIndex = this.mUsageHistoryOfSubtypeListItemIndex[currentUsageRank];
            System.arraycopy(this.mUsageHistoryOfSubtypeListItemIndex, 0, this.mUsageHistoryOfSubtypeListItemIndex, 1, currentUsageRank);
            this.mUsageHistoryOfSubtypeListItemIndex[0] = currentItemIndex;
        }

        public ImeSubtypeListItem getNextInputMethodLocked(boolean onlyCurrentIme, InputMethodInfo imi, InputMethodSubtype subtype) {
            int currentUsageRank = getUsageRank(imi, subtype);
            if (currentUsageRank >= 0) goto L5;
            return null;
        L5:
            int numItems = this.mUsageHistoryOfSubtypeListItemIndex.length;
            int i = 1;
        L6:
            if (i >= numItems) goto L14;
            int subtypeListItemRank = (currentUsageRank + i) % numItems;
            int subtypeListItemIndex = this.mUsageHistoryOfSubtypeListItemIndex[subtypeListItemRank];
            ImeSubtypeListItem subtypeListItem = this.mImeSubtypeList.get(subtypeListItemIndex);
            if (onlyCurrentIme == false) goto L12;
            if (imi.equals(subtypeListItem.mImi) == true) goto L12;
            i = i + 1;
        L12:
            return subtypeListItem;
        L14:
            return null;
        }

        protected void dump(Printer pw, String prefix) {
            int rank = 0;
        L4:
            if (rank >= this.mUsageHistoryOfSubtypeListItemIndex.length) goto L7;
            int index = this.mUsageHistoryOfSubtypeListItemIndex[rank];
            ImeSubtypeListItem item = this.mImeSubtypeList.get(index);
            pw.println(prefix + "rank=" + rank + " item=" + item);
            rank = rank + 1;
            goto L4
        }
    }

    public static class ImeSubtypeListItem implements Comparable<ImeSubtypeListItem> {
        public final CharSequence mImeName;
        public final InputMethodInfo mImi;
        public final boolean mIsSystemLanguage;
        public final boolean mIsSystemLocale;
        public final CharSequence mLayoutName;
        public final int mSubtypeIndex;
        public final CharSequence mSubtypeName;

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(ImeSubtypeListItem r1) {
            return compareTo2(r1);
        }

        ImeSubtypeListItem(CharSequence imeName, CharSequence subtypeName, CharSequence layoutName, InputMethodInfo imi, int subtypeIndex, String subtypeLocale, String systemLocale) {
            this.mImeName = imeName;
            this.mSubtypeName = subtypeName;
            this.mLayoutName = layoutName;
            this.mImi = imi;
            this.mSubtypeIndex = subtypeIndex;
            boolean r1 = false;
            if (TextUtils.isEmpty(subtypeLocale) == false) goto L5;
            this.mIsSystemLocale = false;
            this.mIsSystemLanguage = false;
            return;
        L5:
            this.mIsSystemLocale = subtypeLocale.equals(systemLocale);
            if (this.mIsSystemLocale == false) goto L8;
            this.mIsSystemLanguage = true;
            return;
        L8:
            String systemLanguage = LocaleUtils.getLanguageFromLocaleString(systemLocale);
            String subtypeLanguage = LocaleUtils.getLanguageFromLocaleString(subtypeLocale);
            if (systemLanguage.length() >= 2) goto L11;
        L14:
            this.mIsSystemLanguage = r1;
            return;
        L11:
            if (systemLanguage.equals(subtypeLanguage) == false) goto L14;
            r1 = true;
            goto L14
        }

        private static int compareNullableCharSequences(CharSequence r4, CharSequence r5) {
            boolean r0 = TextUtils.isEmpty(r4);
            boolean r1 = TextUtils.isEmpty(r5);
            if (r0 == true) goto L9;
            if (r1 == true) goto L9;
            return r4.toString().compareTo(r5.toString());
        L9:
            return (r0 ? 1 : 0) - (r1 ? 1 : 0);
        }

        /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
        public int compareTo2(ImeSubtypeListItem other) {
            int result = compareNullableCharSequences(this.mImeName, other.mImeName);
            if (result == 0) goto L5;
            return result;
        L5:
            int r2 = 0;
            if (this.mIsSystemLocale == false) goto L8;
            int r1 = -1;
        L10:
            if (other.mIsSystemLocale == false) goto L12;
            int r4 = -1;
        L13:
            int result2 = r1 - r4;
            if (result2 == 0) goto L17;
            return result2;
        L17:
            if (this.mIsSystemLanguage == false) goto L19;
            int r0 = -1;
        L21:
            if (other.mIsSystemLanguage == false) goto L23;
            r2 = -1;
        L23:
            int result3 = r0 - r2;
            if (result3 == 0) goto L26;
            return result3;
        L26:
            int result4 = compareNullableCharSequences(this.mSubtypeName, other.mSubtypeName);
            if (result4 == 0) goto L30;
            return result4;
        L30:
            return this.mImi.getId().compareTo(other.mImi.getId());
        L19:
            r0 = 0;
            goto L21
        L12:
            r4 = 0;
            goto L13
        L8:
            r1 = 0;
            goto L10
        }

        public String toString() {
            return "ImeSubtypeListItem{mImeName=" + this.mImeName + " mSubtypeName=" + this.mSubtypeName + " mSubtypeIndex=" + this.mSubtypeIndex + " mIsSystemLocale=" + this.mIsSystemLocale + " mIsSystemLanguage=" + this.mIsSystemLanguage + "}";
        }

        public boolean equals(Object o) {
            if (o != this) goto L6;
            return true;
        L6:
            if ((o instanceof ImeSubtypeListItem) == false) goto L14;
            ImeSubtypeListItem that = (ImeSubtypeListItem) o;
            if (Objects.equals(this.mImi, that.mImi) == false) goto L13;
            if (this.mSubtypeIndex != that.mSubtypeIndex) goto L13;
            return true;
        L13:
            return false;
        L14:
            return false;
        }
    }

    private static class RotationList {
        private final List<ImeSubtypeListItem> mItems;
        private final int[] mRecencyMap;

        RotationList(List<ImeSubtypeListItem> items) {
            this.mItems = items;
            this.mRecencyMap = new int[items.size()];
            int i = 0;
        L4:
            if (i >= this.mItems.size()) goto L7;
            this.mRecencyMap[i] = i;
            i = i + 1;
            goto L4
        }

        public ImeSubtypeListItem next(InputMethodInfo imi, InputMethodSubtype subtype, boolean onlyCurrentIme, boolean useRecency, boolean forward) {
            if (this.mItems.isEmpty() == false) goto L5;
            return null;
        L5:
            int index = getIndex(imi, subtype, useRecency);
            if (index >= 0) goto L9;
            Slog.w(InputMethodSubtypeSwitchingController.m4784$$Nest$sfgetTAG(), "Trying to switch away from input method: " + imi + " and subtype " + subtype + " which are not in the list, falling back to most recent item in list.");
            return this.mItems.get(this.mRecencyMap[0]);
        L9:
            if (forward == false) goto L11;
            int incrementSign = 1;
        L12:
            int size = this.mItems.size();
            int i = 1;
        L13:
            if (i >= size) goto L26;
            int nextIndex = (((i * incrementSign) + index) + size) % size;
            if (useRecency == false) goto L17;
            int mappedIndex = this.mRecencyMap[nextIndex];
        L18:
            ImeSubtypeListItem nextItem = this.mItems.get(mappedIndex);
            if (onlyCurrentIme == false) goto L24;
            if (nextItem.mImi.equals(imi) == true) goto L24;
            i = i + 1;
        L24:
            return nextItem;
        L17:
            mappedIndex = nextIndex;
            goto L18
        L26:
            return null;
        L11:
            incrementSign = -1;
            goto L12
        }

        public boolean setMostRecent(InputMethodInfo imi, InputMethodSubtype subtype) {
            if (this.mItems.isEmpty() == false) goto L5;
            return false;
        L5:
            int recencyIndex = getIndex(imi, subtype, true);
            if (recencyIndex > 0) goto L8;
            return false;
        L8:
            int staticIndex = this.mRecencyMap[recencyIndex];
            System.arraycopy(this.mRecencyMap, 0, this.mRecencyMap, 1, recencyIndex);
            this.mRecencyMap[0] = staticIndex;
            return true;
        }

        private int getIndex(InputMethodInfo imi, InputMethodSubtype subtype, boolean useRecency) {
            int subtypeIndex = InputMethodSubtypeSwitchingController.m4785$$Nest$smcalculateSubtypeIndex(imi, subtype);
            int i = 0;
        L4:
            if (i >= this.mItems.size()) goto L14;
            if (useRecency == false) goto L7;
            int mappedIndex = this.mRecencyMap[i];
        L8:
            ImeSubtypeListItem item = this.mItems.get(mappedIndex);
            if (item.mImi.equals(imi) == false) goto L13;
            if (item.mSubtypeIndex != subtypeIndex) goto L13;
            return i;
        L13:
            i = i + 1;
            goto L4
        L7:
            mappedIndex = i;
            goto L8
        L14:
            return -1;
        }

        private void dump(Printer pw, String prefix) {
            pw.println(prefix + "Static order:");
            int i = 0;
        L4:
            if (i >= this.mItems.size()) goto L6;
            ImeSubtypeListItem item = this.mItems.get(i);
            pw.println(prefix + "  i=" + i + " item=" + item);
            i = i + 1;
            goto L4
        L6:
            pw.println(prefix + "Recency order:");
            int i2 = 0;
        L8:
            if (i2 >= this.mRecencyMap.length) goto L11;
            int index = this.mRecencyMap[i2];
            ImeSubtypeListItem item2 = this.mItems.get(index);
            pw.println(prefix + "  i=" + i2 + " item=" + item2);
            i2 = i2 + 1;
            goto L8
        }
    }

    private static class StaticRotationList {
        private final List<ImeSubtypeListItem> mImeSubtypeList;

        /* JADX INFO: renamed from: -$$Nest$fgetmImeSubtypeList, reason: not valid java name */
        static /* bridge */ /* synthetic */ List m4787$$Nest$fgetmImeSubtypeList(StaticRotationList r0) {
            return r0.mImeSubtypeList;
        }

        StaticRotationList(List<ImeSubtypeListItem> imeSubtypeList) {
            this.mImeSubtypeList = imeSubtypeList;
        }

        private int getIndex(InputMethodInfo imi, InputMethodSubtype subtype) {
            int currentSubtypeIndex = InputMethodSubtypeSwitchingController.m4785$$Nest$smcalculateSubtypeIndex(imi, subtype);
            int numSubtypes = this.mImeSubtypeList.size();
            int i = 0;
        L3:
            if (i >= numSubtypes) goto L10;
            ImeSubtypeListItem item = this.mImeSubtypeList.get(i);
            if (imi.equals(item.mImi) == false) goto L9;
            if (item.mSubtypeIndex != currentSubtypeIndex) goto L9;
            return i;
        L9:
            i = i + 1;
            goto L3
        L10:
            return -1;
        }

        public ImeSubtypeListItem getNextInputMethodLocked(boolean onlyCurrentIme, InputMethodInfo imi, InputMethodSubtype subtype) {
            if (this.mImeSubtypeList.size() > 1) goto L5;
            return null;
        L5:
            int currentIndex = getIndex(imi, subtype);
            if (currentIndex >= 0) goto L8;
            return null;
        L8:
            int numSubtypes = this.mImeSubtypeList.size();
            int offset = 1;
        L9:
            if (offset >= numSubtypes) goto L17;
            int candidateIndex = (currentIndex + offset) % numSubtypes;
            ImeSubtypeListItem candidate = this.mImeSubtypeList.get(candidateIndex);
            if (onlyCurrentIme == false) goto L15;
            if (imi.equals(candidate.mImi) == true) goto L15;
            offset = offset + 1;
        L15:
            return candidate;
        L17:
            return null;
        }

        protected void dump(Printer pw, String prefix) {
            int numSubtypes = this.mImeSubtypeList.size();
            int rank = 0;
        L3:
            if (rank >= numSubtypes) goto L6;
            ImeSubtypeListItem item = this.mImeSubtypeList.get(rank);
            pw.println(prefix + "rank=" + rank + " item=" + item);
            rank = rank + 1;
            goto L3
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface SwitchMode {
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetTAG, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m4784$$Nest$sfgetTAG() {
        return TAG;
    }

    /* JADX INFO: renamed from: -$$Nest$smcalculateSubtypeIndex, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m4785$$Nest$smcalculateSubtypeIndex(InputMethodInfo r0, InputMethodSubtype r1) {
        return calculateSubtypeIndex(r0, r1);
    }

    static {
        TAG = InputMethodSubtypeSwitchingController.class.getSimpleName();
    }

    static List<ImeSubtypeListItem> getSortedInputMethodAndSubtypeList(boolean includeAuxiliarySubtypes, boolean isScreenLocked, boolean forImeMenu, Context context, InputMethodSettings settings) {
        int userId = settings.getUserId();
        if (context.getUserId() != userId) goto L5;
        Context userAwareContext = context;
    L6:
        String mSystemLocaleStr = SystemLocaleWrapper.get(userId).get(0).toLanguageTag();
        ArrayList<InputMethodInfo> imis = settings.getEnabledInputMethodList();
        if (imis.isEmpty() == false) goto L10;
        Slog.w(TAG, "Enabled input method list is empty.");
        return new ArrayList();
    L10:
        if (isScreenLocked == false) goto L13;
        if (includeAuxiliarySubtypes == false) goto L13;
        boolean includeAuxiliarySubtypes2 = false;
    L14:
        ArrayList<ImeSubtypeListItem> imList = new ArrayList();
        int numImes = imis.size();
        int i = 0;
    L15:
        if (i >= numImes) goto L50;
        InputMethodInfo imi = imis.get(i);
        if (forImeMenu == true) goto L19;
    L21:
        List<InputMethodSubtype> explicitlyOrImplicitlyEnabledSubtypeList = settings.getEnabledInputMethodSubtypeList(imi, true);
        ArraySet<String> enabledSubtypeSet = new ArraySet();
        Iterator<InputMethodSubtype> r6 = explicitlyOrImplicitlyEnabledSubtypeList.iterator();
    L23:
        if (r6.hasNext() == false) goto L25;
        enabledSubtypeSet.add(String.valueOf(r6.next().hashCode()));
        goto L23
    L25:
        CharSequence imeLabel = imi.loadLabel(userAwareContext.getPackageManager());
        if (enabledSubtypeSet.isEmpty() == true) goto L48;
        int subtypeCount = imi.getSubtypeCount();
        int j = 0;
    L28:
        if (j >= subtypeCount) goto L47;
        InputMethodSubtype subtype = imi.getSubtypeAt(j);
        int userId2 = userId;
        String subtypeHashCode = String.valueOf(subtype.hashCode());
        if (enabledSubtypeSet.contains(subtypeHashCode) == false) goto L45;
        if (includeAuxiliarySubtypes2 == false) goto L33;
    L36:
        CharSequence layoutName = null;
        if (subtype.overridesImplicitlyEnabledSubtype() == false) goto L39;
        CharSequence subtypeLabel = null;
    L41:
        if (subtype.overridesImplicitlyEnabledSubtype() == true) goto L44;
        layoutName = subtype.getLayoutDisplayName(userAwareContext, imi.getServiceInfo().applicationInfo);
    L44:
        ArraySet<String> enabledSubtypeSet2 = enabledSubtypeSet;
        CharSequence imeLabel2 = imeLabel;
        imList.add(new ImeSubtypeListItem(imeLabel2, subtypeLabel, layoutName, imi, j, subtype.getLocale(), mSystemLocaleStr));
        enabledSubtypeSet2.remove(subtypeHashCode);
    L46:
        j = j + 1;
        subtypeCount = subtypeCount;
        enabledSubtypeSet = enabledSubtypeSet2;
        imeLabel = imeLabel2;
        imis = imis;
        userId = userId2;
        goto L28
    L39:
        subtypeLabel = subtype.getDisplayName(userAwareContext, imi.getPackageName(), imi.getServiceInfo().applicationInfo);
        goto L41
    L33:
        if (subtype.isAuxiliary() == false) goto L36;
        imis = imis;
        enabledSubtypeSet2 = enabledSubtypeSet;
        imeLabel2 = imeLabel;
        goto L46
    L45:
        imis = imis;
        enabledSubtypeSet2 = enabledSubtypeSet;
        imeLabel2 = imeLabel;
        goto L46
    L47:
        int userId3 = userId;
        ArrayList<InputMethodInfo> imis2 = imis;
    L49:
        i = i + 1;
        imis = imis2;
        userId = userId3;
        goto L15
    L48:
        userId3 = userId;
        imis2 = imis;
        imList.add(new ImeSubtypeListItem(imeLabel, null, null, imi, -1, null, mSystemLocaleStr));
        goto L49
    L19:
        if (imi.shouldShowInInputMethodPicker() == true) goto L21;
        userId3 = userId;
        imis2 = imis;
        goto L49
    L50:
        Collections.sort(imList);
        return imList;
    L13:
        includeAuxiliarySubtypes2 = includeAuxiliarySubtypes;
        goto L14
    L5:
        userAwareContext = context.createContextAsUser(UserHandle.of(userId), 0);
        goto L6
    }

    private static List<ImeSubtypeListItem> getInputMethodAndSubtypeListForHardwareKeyboard(Context context, InputMethodSettings settings) {
        return new ArrayList();
    }

    private static int calculateSubtypeIndex(InputMethodInfo imi, InputMethodSubtype subtype) {
        if (subtype != null) goto L6;
        return -1;
    L6:
        return SubtypeUtils.getSubtypeIndexFromHashCode(imi, subtype.hashCode());
    }

    void update(List<ImeSubtypeListItem> sortedEnabledItems, List<ImeSubtypeListItem> hardwareKeyboardItems) {
        List<ImeSubtypeListItem> switchingAwareImeSubtypes = filterImeSubtypeList(sortedEnabledItems, true);
        List<ImeSubtypeListItem> switchingUnawareImeSubtypes = filterImeSubtypeList(sortedEnabledItems, false);
        if (Objects.equals(DynamicRotationList.m4786$$Nest$fgetmImeSubtypeList(this.mSwitchingAwareRotationList), switchingAwareImeSubtypes) == true) goto L6;
        this.mSwitchingAwareRotationList = new DynamicRotationList(switchingAwareImeSubtypes, null);
    L6:
        if (Objects.equals(StaticRotationList.m4787$$Nest$fgetmImeSubtypeList(this.mSwitchingUnawareRotationList), switchingUnawareImeSubtypes) == true) goto L10;
        this.mSwitchingUnawareRotationList = new StaticRotationList(switchingUnawareImeSubtypes);
        return;
    }

    public ImeSubtypeListItem getNextInputMethodLocked(boolean onlyCurrentIme, InputMethodInfo imi, InputMethodSubtype subtype, int mode, boolean forward) {
        if (imi.supportsSwitchingToNextInputMethod() == false) goto L7;
        return this.mSwitchingAwareRotationList.getNextInputMethodLocked(onlyCurrentIme, imi, subtype);
    L7:
        return this.mSwitchingUnawareRotationList.getNextInputMethodLocked(onlyCurrentIme, imi, subtype);
    }

    public ImeSubtypeListItem getNextInputMethodForHardware(boolean onlyCurrentIme, InputMethodInfo imi, InputMethodSubtype subtype, int mode, boolean forward) {
        return null;
    }

    public boolean onUserActionLocked(InputMethodInfo imi, InputMethodSubtype subtype) {
        if (imi.supportsSwitchingToNextInputMethod() == false) goto L5;
        this.mSwitchingAwareRotationList.onUserAction(imi, subtype);
    L5:
        return false;
    }

    public void onInputMethodSubtypeChanged() {
        this.mUserActionSinceSwitch = false;
    }

    private boolean isRecency(int mode, boolean forward) {
        if (mode == 2) goto L5;
    L8:
        if (mode == 1) goto L12;
        return false;
    L12:
        return true;
    L5:
        if (this.mUserActionSinceSwitch == false) goto L8;
        if (forward == false) goto L8;
        return true;
    }

    private static List<ImeSubtypeListItem> filterImeSubtypeList(List<ImeSubtypeListItem> items, boolean supportsSwitchingToNextInputMethod) {
        ArrayList<ImeSubtypeListItem> result = new ArrayList();
        int numItems = items.size();
        int i = 0;
    L3:
        if (i >= numItems) goto L9;
        ImeSubtypeListItem item = items.get(i);
        if (item.mImi.supportsSwitchingToNextInputMethod() != supportsSwitchingToNextInputMethod) goto L7;
        result.add(item);
    L7:
        i = i + 1;
        goto L3
    L9:
        return result;
    }

    void dump(Printer pw, String prefix) {
        pw.println(prefix + "mSwitchingAwareRotationList:");
        this.mSwitchingAwareRotationList.dump(pw, prefix + "  ");
        pw.println(prefix + "mSwitchingUnawareRotationList:");
        this.mSwitchingUnawareRotationList.dump(pw, prefix + "  ");
    }

    InputMethodSubtypeSwitchingController() {
        this.mSwitchingAwareRotationList = new DynamicRotationList(Collections.emptyList(), null);
        this.mSwitchingUnawareRotationList = new StaticRotationList(Collections.emptyList());
        this.mRotationList = new RotationList(Collections.emptyList());
        this.mHardwareRotationList = new RotationList(Collections.emptyList());
    }

    public void resetCircularListLocked(Context context, InputMethodSettings settings) {
        update(getSortedInputMethodAndSubtypeList(false, false, false, context, settings), getInputMethodAndSubtypeListForHardwareKeyboard(context, settings));
    }
}
