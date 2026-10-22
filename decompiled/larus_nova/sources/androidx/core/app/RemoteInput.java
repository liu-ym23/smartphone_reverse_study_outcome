package androidx.core.app;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sysoptimizer.BadParcelableCrashOptimizer;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes17.dex */
public final class RemoteInput {
    public static final int EDIT_CHOICES_BEFORE_SENDING_AUTO = 0;
    public static final int EDIT_CHOICES_BEFORE_SENDING_DISABLED = 1;
    public static final int EDIT_CHOICES_BEFORE_SENDING_ENABLED = 2;
    private static final String EXTRA_DATA_TYPE_RESULTS_DATA = "android.remoteinput.dataTypeResultsData";
    public static final String EXTRA_RESULTS_DATA = "android.remoteinput.resultsData";
    private static final String EXTRA_RESULTS_SOURCE = "android.remoteinput.resultsSource";
    public static final String RESULTS_CLIP_LABEL = "android.remoteinput.results";
    public static final int SOURCE_CHOICE = 1;
    public static final int SOURCE_FREE_FORM_INPUT = 0;
    private final boolean mAllowFreeFormTextInput;
    private final Set<String> mAllowedDataTypes;
    private final CharSequence[] mChoices;
    private final int mEditChoicesBeforeSending;
    private final Bundle mExtras;
    private final CharSequence mLabel;
    private final String mResultKey;

    public static class Api20Impl {
        private Api20Impl() {
        }

        public static android.app.RemoteInput fromCompat(RemoteInput r100) {
            android.app.RemoteInput.Builder r101 = new android.app.RemoteInput.Builder(r100.getResultKey()).setLabel(r100.getLabel()).setChoices(r100.getChoices()).setAllowFreeFormInput(r100.getAllowFreeFormInput()).addExtras(r100.getExtras());
            if (Build.VERSION.SDK_INT < 26) goto L11;
            Set<String> r102 = r100.getAllowedDataTypes();
            if (r102 == null) goto L11;
            Iterator<String> r103 = r102.iterator();
        L8:
            if (r103.hasNext() == false) goto L11;
            Api26Impl.setAllowDataType(r101, r103.next(), true);
        L11:
            if (Build.VERSION.SDK_INT < 29) goto L14;
            Api29Impl.setEditChoicesBeforeSending(r101, r100.getEditChoicesBeforeSending());
        L14:
            return r101.build();
        }

        public static RemoteInput fromPlatform(Object r100) {
            android.app.RemoteInput r101 = (android.app.RemoteInput) r100;
            Builder r102 = new Builder(r101.getResultKey()).setLabel(r101.getLabel()).setChoices(r101.getChoices()).setAllowFreeFormInput(r101.getAllowFreeFormInput()).addExtras(r101.getExtras());
            if (Build.VERSION.SDK_INT < 26) goto L11;
            Set<String> r103 = Api26Impl.getAllowedDataTypes(r101);
            if (r103 == null) goto L11;
            Iterator<String> r104 = r103.iterator();
        L8:
            if (r104.hasNext() == false) goto L11;
            r102.setAllowDataType(r104.next(), true);
        L11:
            if (Build.VERSION.SDK_INT < 29) goto L14;
            r102.setEditChoicesBeforeSending(Api29Impl.getEditChoicesBeforeSending(r101));
        L14:
            return r102.build();
        }

        public static Bundle getResultsFromIntent(Intent r100) {
            return android.app.RemoteInput.getResultsFromIntent(r100);
        }

        public static void addResultsToIntent(Object r100, Intent r101, Bundle r102) {
            android.app.RemoteInput.addResultsToIntent((android.app.RemoteInput[]) r100, r101, r102);
        }
    }

    public static class Api26Impl {
        private Api26Impl() {
        }

        public static Set<String> getAllowedDataTypes(Object r100) {
            return ((android.app.RemoteInput) r100).getAllowedDataTypes();
        }

        public static Map<String, Uri> getDataResultsFromIntent(Intent r100, String r101) {
            return android.app.RemoteInput.getDataResultsFromIntent(r100, r101);
        }

        public static void addDataResultToIntent(RemoteInput r100, Intent r101, Map<String, Uri> r102) {
            android.app.RemoteInput.addDataResultToIntent(RemoteInput.fromCompat(r100), r101, r102);
        }

        public static android.app.RemoteInput.Builder setAllowDataType(android.app.RemoteInput.Builder r100, String r101, boolean r102) {
            return r100.setAllowDataType(r101, r102);
        }
    }

    public static class Api28Impl {
        private Api28Impl() {
        }

        public static int getResultsSource(Intent r100) {
            return android.app.RemoteInput.getResultsSource(r100);
        }

        public static void setResultsSource(Intent r100, int r101) {
            android.app.RemoteInput.setResultsSource(r100, r101);
        }
    }

    public static class Api29Impl {
        private Api29Impl() {
        }

        public static int getEditChoicesBeforeSending(Object r100) {
            return ((android.app.RemoteInput) r100).getEditChoicesBeforeSending();
        }

        public static android.app.RemoteInput.Builder setEditChoicesBeforeSending(android.app.RemoteInput.Builder r100, int r101) {
            return r100.setEditChoicesBeforeSending(r101);
        }
    }

    public static final class Builder {
        private boolean mAllowFreeFormTextInput;
        private final Set<String> mAllowedDataTypes;
        private CharSequence[] mChoices;
        private int mEditChoicesBeforeSending;
        private final Bundle mExtras;
        private CharSequence mLabel;
        private final String mResultKey;

        public RemoteInput build() {
            return new RemoteInput(this.mResultKey, this.mLabel, this.mChoices, this.mAllowFreeFormTextInput, this.mEditChoicesBeforeSending, this.mExtras, this.mAllowedDataTypes);
        }

        public Bundle getExtras() {
            return this.mExtras;
        }

        public Builder(String r100) {
            this.mAllowedDataTypes = new HashSet();
            this.mExtras = new Bundle();
            this.mAllowFreeFormTextInput = true;
            this.mEditChoicesBeforeSending = 0;
            if (r100 == null) goto L7;
            this.mResultKey = r100;
            return;
        L7:
            throw new IllegalArgumentException("Result key can't be null");
        }

        public Builder addExtras(Bundle r100) {
            if (r100 == null) goto L4;
            this.mExtras.putAll(r100);
        L4:
            return this;
        }

        public Builder setAllowFreeFormInput(boolean r100) {
            this.mAllowFreeFormTextInput = r100;
            return this;
        }

        public Builder setChoices(CharSequence[] r100) {
            this.mChoices = r100;
            return this;
        }

        public Builder setEditChoicesBeforeSending(int r100) {
            this.mEditChoicesBeforeSending = r100;
            return this;
        }

        public Builder setLabel(CharSequence r100) {
            this.mLabel = r100;
            return this;
        }

        public Builder setAllowDataType(String r100, boolean r101) {
            if (r101 == false) goto L4;
            this.mAllowedDataTypes.add(r100);
        L5:
            return this;
        L4:
            this.mAllowedDataTypes.remove(r100);
            goto L5
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface EditChoicesBeforeSending {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Source {
    }

    public boolean isDataOnly() {
        if (getAllowFreeFormInput() == false) goto L5;
    L13:
        return false;
    L5:
        if (getChoices() == null) goto L9;
        if (getChoices().length != 0) goto L13;
    L9:
        if (getAllowedDataTypes() == null) goto L13;
        if (getAllowedDataTypes().isEmpty() == true) goto L13;
        return true;
    }

    public boolean getAllowFreeFormInput() {
        return this.mAllowFreeFormTextInput;
    }

    public Set<String> getAllowedDataTypes() {
        return this.mAllowedDataTypes;
    }

    public CharSequence[] getChoices() {
        return this.mChoices;
    }

    public int getEditChoicesBeforeSending() {
        return this.mEditChoicesBeforeSending;
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public CharSequence getLabel() {
        return this.mLabel;
    }

    public String getResultKey() {
        return this.mResultKey;
    }

    public static android.app.RemoteInput[] fromCompat(RemoteInput[] r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        android.app.RemoteInput[] r101 = new android.app.RemoteInput[r100.length];
        int r102 = 0;
    L7:
        if (r102 >= r100.length) goto L9;
        r101[r102] = fromCompat(r100[r102]);
        r102 = r102 + 1;
        goto L7
    L9:
        return r101;
    }

    public static RemoteInput fromPlatform(android.app.RemoteInput r100) {
        return Api20Impl.fromPlatform(r100);
    }

    private static Intent getClipDataIntentFromIntent(Intent r100) {
        ClipData r101 = r100.getClipData();
        if (r101 != null) goto L5;
        return null;
    L5:
        ClipDescription r102 = r101.getDescription();
        if (r102.hasMimeType("text/vnd.android.intent") == true) goto L9;
        return null;
    L9:
        if (r102.getLabel().toString().contentEquals(RESULTS_CLIP_LABEL) == true) goto L12;
        return null;
    L12:
        return r101.getItemAt(0).getIntent();
    }

    private static String getExtraResultsKeyForData(String r100) {
        return EXTRA_DATA_TYPE_RESULTS_DATA + r100;
    }

    public static Bundle getResultsFromIntent(Intent r100) {
        return Api20Impl.getResultsFromIntent(r100);
    }

    public static int getResultsSource(Intent r100) {
        if (Build.VERSION.SDK_INT >= 28) goto L5;
        Intent r101 = getClipDataIntentFromIntent(r100);
        if (r101 != null) goto L10;
        return 0;
    L10:
        return r101.getExtras().getInt(EXTRA_RESULTS_SOURCE, 0);
    L5:
        return Api28Impl.getResultsSource(r100);
    }

    public static android.app.RemoteInput fromCompat(RemoteInput r100) {
        return Api20Impl.fromCompat(r100);
    }

    public static Bundle INVOKEVIRTUAL_androidx_core_app_RemoteInput_com_bytedance_sysoptimizer_BadParcelableLancet_getBundleExtra(Intent r100, String r101) {
        Bundle r102 = r100.getBundleExtra(r101);
        Context r103 = BadParcelableCrashOptimizer.getContext();
        if (r102 == null) goto L6;
        if (r103 == null) goto L6;
        r102.setClassLoader(r103.getClassLoader());
    L6:
        return r102;
    }

    public static Map<String, Uri> getDataResultsFromIntent(Intent r100, String r101) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        Intent r102 = getClipDataIntentFromIntent(r100);
        if (r102 != null) goto L9;
        return null;
    L9:
        HashMap r103 = new HashMap();
        Iterator<String> r104 = r102.getExtras().keySet().iterator();
    L11:
        if (r104.hasNext() == false) goto L24;
        String r105 = r104.next();
        if (r105.startsWith(EXTRA_DATA_TYPE_RESULTS_DATA) == false) goto L11;
        String r106 = r105.substring(39);
        if (r106.isEmpty() == true) goto L11;
        String r107 = INVOKEVIRTUAL_androidx_core_app_RemoteInput_com_bytedance_sysoptimizer_BadParcelableLancet_getBundleExtra(r102, r105).getString(r101);
        if (r107 == null) goto L11;
        if (r107.isEmpty() == true) goto L11;
        r103.put(r106, UriProtector.parse(r107));
        goto L11
    L24:
        if (r103.isEmpty() == false) goto L27;
        return null;
    L27:
        return r103;
    L5:
        return Api26Impl.getDataResultsFromIntent(r100, r101);
    }

    public static void setResultsSource(Intent r100, int r101) {
        if (Build.VERSION.SDK_INT < 28) goto L5;
        Api28Impl.setResultsSource(r100, r101);
        return;
    L5:
        Intent r102 = getClipDataIntentFromIntent(r100);
        if (r102 != null) goto L8;
        r102 = new Intent();
    L8:
        r102.putExtra(EXTRA_RESULTS_SOURCE, r101);
        r100.setClipData(ClipData.newIntent(RESULTS_CLIP_LABEL, r102));
    }

    public static void addDataResultToIntent(RemoteInput r100, Intent r101, Map<String, Uri> r102) {
        if (Build.VERSION.SDK_INT < 26) goto L5;
        Api26Impl.addDataResultToIntent(r100, r101, r102);
        return;
    L5:
        Intent r103 = getClipDataIntentFromIntent(r101);
        if (r103 != null) goto L8;
        r103 = new Intent();
    L8:
        Iterator<Map.Entry<String, Uri>> r104 = r102.entrySet().iterator();
    L10:
        if (r104.hasNext() == false) goto L18;
        Map.Entry<String, Uri> r105 = r104.next();
        String r106 = r105.getKey();
        Uri r107 = r105.getValue();
        if (r106 == null) goto L10;
        Bundle r108 = INVOKEVIRTUAL_androidx_core_app_RemoteInput_com_bytedance_sysoptimizer_BadParcelableLancet_getBundleExtra(r103, getExtraResultsKeyForData(r106));
        if (r108 != null) goto L17;
        r108 = new Bundle();
    L17:
        r108.putString(r100.getResultKey(), r107.toString());
        r103.putExtra(getExtraResultsKeyForData(r106), r108);
        goto L10
    L18:
        r101.setClipData(ClipData.newIntent(RESULTS_CLIP_LABEL, r103));
    }

    public static void addResultsToIntent(RemoteInput[] r100, Intent r101, Bundle r102) {
        if (Build.VERSION.SDK_INT < 26) goto L5;
        Api20Impl.addResultsToIntent(fromCompat(r100), r101, r102);
        return;
    L5:
        Bundle r103 = getResultsFromIntent(r101);
        int r104 = getResultsSource(r101);
        if (r103 == null) goto L9;
        r103.putAll(r102);
        r102 = r103;
    L9:
        int r105 = r100.length;
        int r106 = 0;
    L10:
        if (r106 >= r105) goto L15;
        RemoteInput r107 = r100[r106];
        Map<String, Uri> r108 = getDataResultsFromIntent(r101, r107.getResultKey());
        Api20Impl.addResultsToIntent(fromCompat(new RemoteInput[]{r107}), r101, r102);
        if (r108 == null) goto L14;
        addDataResultToIntent(r107, r101, r108);
    L14:
        r106 = r106 + 1;
        goto L10
    L15:
        setResultsSource(r101, r104);
    }

    public RemoteInput(String r100, CharSequence r101, CharSequence[] r102, boolean r103, int r104, Bundle r105, Set<String> r106) {
        this.mResultKey = r100;
        this.mLabel = r101;
        this.mChoices = r102;
        this.mAllowFreeFormTextInput = r103;
        this.mEditChoicesBeforeSending = r104;
        this.mExtras = r105;
        this.mAllowedDataTypes = r106;
        if (getEditChoicesBeforeSending() == 2) goto L5;
        return;
    L5:
        if (getAllowFreeFormInput() == false) goto L8;
        return;
    L8:
        throw new IllegalArgumentException("setEditChoicesBeforeSending requires setAllowFreeFormInput");
    }
}
