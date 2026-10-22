package com.obric.oui.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.SparseArray;
import android.util.Xml;
import com.GlobalProxyLancet;
import com.bytedance.librarian.LibrarianImpl;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes3.dex */
public class ConstraintLayoutStates {
    private static final boolean DEBUG = false;
    public static final String TAG = "ConstraintLayoutStates";
    private final ConstraintLayout mConstraintLayout;
    private SparseArray<ConstraintSet> mConstraintSetMap;
    private ConstraintsChangedListener mConstraintsChangedListener;
    int mCurrentConstraintNumber;
    int mCurrentStateId;
    ConstraintSet mDefaultConstraintSet;
    private SparseArray<State> mStateList;

    static class State {
        int mConstraintID;
        ConstraintSet mConstraintSet;
        int mId;
        ArrayList<Variant> mVariants;

        State(Context r6, XmlPullParser r7) {
            this.mVariants = new ArrayList();
            this.mConstraintID = -1;
            TypedArray r8 = r6.obtainStyledAttributes(Xml.asAttributeSet(r7), R.styleable.State);
            int r0 = r8.getIndexCount();
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L13;
            int r2 = r8.getIndex(r1);
            if (r2 != R.styleable.State_android_id) goto L8;
            this.mId = r8.getResourceId(r2, this.mId);
        L12:
            r1 = r1 + 1;
            goto L3
        L8:
            if (r2 != R.styleable.State_constraints) goto L12;
            this.mConstraintID = r8.getResourceId(r2, this.mConstraintID);
            String r3 = r6.getResources().getResourceTypeName(this.mConstraintID);
            r6.getResources().getResourceName(this.mConstraintID);
            if ("layout".equals(r3) == false) goto L12;
            ConstraintSet r4 = new ConstraintSet();
            this.mConstraintSet = r4;
            r4.clone(r6, this.mConstraintID);
            goto L12
        L13:
            r8.recycle();
        }

        void add(Variant r1) {
            this.mVariants.add(r1);
        }

        public int findMatch(float r3, float r4) {
            int r0 = 0;
        L4:
            if (r0 >= this.mVariants.size()) goto L9;
            if (this.mVariants.get(r0).match(r3, r4) == true) goto L7;
            r0 = r0 + 1;
            goto L4
        L7:
            return r0;
        L9:
            return -1;
        }
    }

    static class Variant {
        int mConstraintID;
        ConstraintSet mConstraintSet;
        int mId;
        float mMaxHeight;
        float mMaxWidth;
        float mMinHeight;
        float mMinWidth;

        Variant(Context r6, XmlPullParser r7) {
            this.mMinWidth = Float.NaN;
            this.mMinHeight = Float.NaN;
            this.mMaxWidth = Float.NaN;
            this.mMaxHeight = Float.NaN;
            this.mConstraintID = -1;
            TypedArray r8 = r6.obtainStyledAttributes(Xml.asAttributeSet(r7), R.styleable.Variant);
            int r0 = r8.getIndexCount();
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L23;
            int r2 = r8.getIndex(r1);
            if (r2 != R.styleable.Variant_constraints) goto L10;
            this.mConstraintID = r8.getResourceId(r2, this.mConstraintID);
            String r3 = r6.getResources().getResourceTypeName(this.mConstraintID);
            r6.getResources().getResourceName(this.mConstraintID);
            if ("layout".equals(r3) == false) goto L22;
            ConstraintSet r4 = new ConstraintSet();
            this.mConstraintSet = r4;
            r4.clone(r6, this.mConstraintID);
        L22:
            r1 = r1 + 1;
            goto L3
        L10:
            if (r2 != R.styleable.Variant_region_heightLessThan) goto L13;
            this.mMaxHeight = r8.getDimension(r2, this.mMaxHeight);
            goto L22
        L13:
            if (r2 != R.styleable.Variant_region_heightMoreThan) goto L16;
            this.mMinHeight = r8.getDimension(r2, this.mMinHeight);
            goto L22
        L16:
            if (r2 != R.styleable.Variant_region_widthLessThan) goto L19;
            this.mMaxWidth = r8.getDimension(r2, this.mMaxWidth);
            goto L22
        L19:
            if (r2 != R.styleable.Variant_region_widthMoreThan) goto L21;
            this.mMinWidth = r8.getDimension(r2, this.mMinWidth);
            goto L22
        L21:
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_v("ConstraintLayoutStates", "Unknown tag");
            goto L22
        L23:
            r8.recycle();
        }

        boolean match(float r3, float r4) {
            if (Float.isNaN(this.mMinWidth) == true) goto L8;
            if (r3 >= this.mMinWidth) goto L8;
            return false;
        L8:
            if (Float.isNaN(this.mMinHeight) == true) goto L13;
            if (r4 >= this.mMinHeight) goto L13;
            return false;
        L13:
            if (Float.isNaN(this.mMaxWidth) == true) goto L18;
            if (r3 <= this.mMaxWidth) goto L18;
            return false;
        L18:
            if (Float.isNaN(this.mMaxHeight) == false) goto L20;
            return true;
        L20:
            if (r4 <= this.mMaxHeight) goto L24;
            return false;
        L24:
            return true;
        }
    }

    ConstraintLayoutStates(Context r2, ConstraintLayout r3, int r4) {
        this.mCurrentStateId = -1;
        this.mCurrentConstraintNumber = -1;
        this.mStateList = new SparseArray();
        this.mConstraintSetMap = new SparseArray();
        this.mConstraintsChangedListener = null;
        this.mConstraintLayout = r3;
        load(r2, r4);
    }

    public boolean needsToChange(int r5, float r6, float r7) {
        int r0 = this.mCurrentStateId;
        if (r0 == r5) goto L6;
        return true;
    L6:
        if (r5 != (-1)) goto L8;
        State r8 = this.mStateList.valueAt(0);
    L9:
        State r9 = r8;
        if (this.mCurrentConstraintNumber == (-1)) goto L15;
        if (r9.mVariants.get(this.mCurrentConstraintNumber).match(r6, r7) == false) goto L15;
        return false;
    L15:
        if (this.mCurrentConstraintNumber != r9.findMatch(r6, r7)) goto L17;
        return false;
    L17:
        return true;
    L8:
        r8 = this.mStateList.get(r0);
        goto L9
    }

    public void updateConstraints(int r5, float r6, float r7) {
        int r0 = this.mCurrentStateId;
        if (r0 != r5) goto L29;
        if (r5 != (-1)) goto L6;
        State r8 = this.mStateList.valueAt(0);
    L8:
        if (this.mCurrentConstraintNumber != (-1)) goto L10;
    L12:
        int r9 = r8.findMatch(r6, r7);
        if (this.mCurrentConstraintNumber != r9) goto L15;
        return;
    L15:
        if (r9 != (-1)) goto L17;
        ConstraintSet r10 = this.mDefaultConstraintSet;
    L18:
        if (r9 != (-1)) goto L20;
        int r11 = r8.mConstraintID;
    L21:
        if (r10 != null) goto L23;
        return;
    L23:
        this.mCurrentConstraintNumber = r9;
        ConstraintsChangedListener r12 = this.mConstraintsChangedListener;
        if (r12 == null) goto L26;
        r12.preLayoutChange(-1, r11);
    L26:
        r10.applyTo(this.mConstraintLayout);
        ConstraintsChangedListener r4 = this.mConstraintsChangedListener;
        if (r4 == null) goto L46;
        r4.postLayoutChange(-1, r11);
        return;
    L46:
        return;
    L20:
        r11 = r8.mVariants.get(r9).mConstraintID;
        goto L21
    L17:
        r10 = r8.mVariants.get(r9).mConstraintSet;
        goto L18
    L10:
        if (r8.mVariants.get(this.mCurrentConstraintNumber).match(r6, r7) == false) goto L12;
        return;
    L6:
        r8 = this.mStateList.get(r0);
        goto L8
    L29:
        this.mCurrentStateId = r5;
        State r1 = this.mStateList.get(r5);
        int r2 = r1.findMatch(r6, r7);
        if (r2 != (-1)) goto L32;
        ConstraintSet r3 = r1.mConstraintSet;
    L33:
        if (r2 != (-1)) goto L35;
        int r13 = r1.mConstraintID;
    L36:
        if (r3 != null) goto L39;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_v("ConstraintLayoutStates", "NO Constraint set found ! id=" + r5 + ", dim =" + r6 + ", " + r7);
        return;
    L39:
        this.mCurrentConstraintNumber = r2;
        ConstraintsChangedListener r14 = this.mConstraintsChangedListener;
        if (r14 == null) goto L42;
        r14.preLayoutChange(r5, r13);
    L42:
        r3.applyTo(this.mConstraintLayout);
        ConstraintsChangedListener r15 = this.mConstraintsChangedListener;
        if (r15 == null) goto L48;
        r15.postLayoutChange(r5, r13);
        return;
    L48:
        return;
    L35:
        r13 = r1.mVariants.get(r2).mConstraintID;
        goto L36
    L32:
        r3 = r1.mVariants.get(r2).mConstraintSet;
        goto L33
    }

    public void setOnConstraintsChanged(ConstraintsChangedListener r1) {
        this.mConstraintsChangedListener = r1;
    }

    private void load(Context r11, int r12) {
        XmlResourceParser r2 = r11.getResources().getXml(r12);
        int r3 = r2.getEventType();     // Catch: IOException -> L39 XmlPullParserException -> L41
        State r4 = null;
    L4:
        byte r5 = 1;
        if (r3 == 1) goto L55;
        if (r3 != 2) goto L37;
        String r6 = r2.getName();     // Catch: IOException -> L39 XmlPullParserException -> L41
        switch(r6.hashCode()) {
            case -1349929691: goto L25;
            case 80204913: goto L22;
            case 1382829617: goto L19;
            case 1657696882: goto L16;
            case 1901439077: goto L13;
            default: goto L27;
        };     // Catch: IOException -> L39 XmlPullParserException -> L41
    L27:
        r5 = -1;
    L28:
        if (r5 == 2) goto L36;
        if (r5 == 3) goto L33;
        if (r5 != 4) goto L37;
        parseConstraintSet(r11, r2);     // Catch: IOException -> L39 XmlPullParserException -> L41
        goto L37
    L33:
        Variant r7 = new Variant(r11, r2);     // Catch: IOException -> L39 XmlPullParserException -> L41
        if (r4 == null) goto L37;
        r4.add(r7);     // Catch: IOException -> L39 XmlPullParserException -> L41
        goto L37
    L36:
        State r8 = new State(r11, r2);     // Catch: IOException -> L39 XmlPullParserException -> L41
        this.mStateList.put(r8.mId, r8);     // Catch: IOException -> L39 XmlPullParserException -> L41
        r4 = r8;
        goto L37
    L13:
        if (r6.equals("Variant") == false) goto L27;
        r5 = 3;
        goto L28
    L16:
        if (r6.equals("layoutDescription") == false) goto L27;
        r5 = 0;
        goto L28
    L19:
        if (r6.equals("StateSet") == false) goto L27;
    L22:
        if (r6.equals("State") == false) goto L27;
        r5 = 2;
        goto L28
    L25:
        if (r6.equals("ConstraintSet") == false) goto L27;
        r5 = 4;
    L37:
        r3 = r2.next();     // Catch: IOException -> L39 XmlPullParserException -> L41
    L55:
        return;
    L39:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e("ConstraintLayoutStates", "Error parsing resource: " + r12, e);
        return;
    L41:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e("ConstraintLayoutStates", "Error parsing resource: " + r12, e);
    }

    private void parseConstraintSet(Context r9, XmlPullParser r10) {
        ConstraintSet r0 = new ConstraintSet();
        int r1 = r10.getAttributeCount();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L27;
        String r3 = r10.getAttributeName(r2);
        String r4 = r10.getAttributeValue(r2);
        if (r3 == null) goto L20;
        if (r4 == null) goto L20;
        if ("id".equals(r3) == false) goto L20;
        if (r4.contains(LibrarianImpl.Constants.SEPARATOR) == false) goto L13;
        int r5 = r9.getResources().getIdentifier(r4.substring(r4.indexOf(47) + 1), "id", r9.getPackageName());
    L14:
        if (r5 == (-1)) goto L16;
    L19:
        r0.load(r9, r10);
        this.mConstraintSetMap.put(r5, r0);
        return;
    L16:
        if (r4.length() <= 1) goto L18;
        r5 = Integer.parseInt(r4.substring(1));
        goto L19
    L18:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e("ConstraintLayoutStates", "error in parsing id");
        goto L19
    L13:
        r5 = -1;
    L20:
        r2 = r2 + 1;
        goto L3
    }
}
