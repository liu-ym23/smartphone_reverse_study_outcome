package com.stepos.widget.preference;

import android.content.Context;
import android.util.AttributeSet;
import androidx.preference.Preference;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007J,\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u000e\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\r2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007¨\u0006\u000e"}, d2 = {"Lcom/stepos/widget/preference/StepOSPreferenceFactory;", "", "<init>", "()V", "create", "Landroidx/preference/Preference;", "context", "Landroid/content/Context;", "name", "", "attrs", "Landroid/util/AttributeSet;", "clazz", "Ljava/lang/Class;", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StepOSPreferenceFactory {
    public static final StepOSPreferenceFactory INSTANCE = new StepOSPreferenceFactory();

    private StepOSPreferenceFactory() {
    }

    public static final Preference create(Context context, Class<? extends Preference> clazz) {
        p.i(context, "context");
        p.i(clazz, "clazz");
        return create$default(context, clazz, (AttributeSet) null, 4, (Object) null);
    }

    public static /* synthetic */ Preference create$default(Context context, String str, AttributeSet attributeSet, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            attributeSet = null;
        }
        return create(context, str, attributeSet);
    }

    public static final Preference create(Context context, String name) {
        p.i(context, "context");
        p.i(name, "name");
        return create$default(context, name, (AttributeSet) null, 4, (Object) null);
    }

    public static /* synthetic */ Preference create$default(Context context, Class cls, AttributeSet attributeSet, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            attributeSet = null;
        }
        return create(context, (Class<? extends Preference>) cls, attributeSet);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static final Preference create(Context context, String name, AttributeSet attrs) {
        AttributeSet attributeSet;
        Context context2;
        p.i(context, "context");
        p.i(name, "name");
        switch (name.hashCode()) {
            case 190073777:
                if (name.equals("SwitchPreferenceCompat")) {
                    attributeSet = attrs;
                    context2 = context;
                    return new StepOSSwitchPreference(context2, attributeSet, 0, 0, 12, null);
                }
                throw new IllegalArgumentException("Unknown preference short name \"" + name + "\". Supported: Preference, SwitchPreferenceCompat, SwitchPreference, PreferenceCategory. For FQCN customs, construct the class directly or subclass StepOSPreference.");
            case 533633275:
                if (name.equals("Preference")) {
                    return new StepOSPreference(context, attrs, 0, 0, 12, null);
                }
                throw new IllegalArgumentException("Unknown preference short name \"" + name + "\". Supported: Preference, SwitchPreferenceCompat, SwitchPreference, PreferenceCategory. For FQCN customs, construct the class directly or subclass StepOSPreference.");
            case 889856847:
                if (name.equals("SwitchPreference")) {
                    context2 = context;
                    attributeSet = attrs;
                    return new StepOSSwitchPreference(context2, attributeSet, 0, 0, 12, null);
                }
                throw new IllegalArgumentException("Unknown preference short name \"" + name + "\". Supported: Preference, SwitchPreferenceCompat, SwitchPreference, PreferenceCategory. For FQCN customs, construct the class directly or subclass StepOSPreference.");
            case 2041351961:
                if (name.equals("PreferenceCategory")) {
                    return new StepOSPreferenceCategory(context, attrs);
                }
                throw new IllegalArgumentException("Unknown preference short name \"" + name + "\". Supported: Preference, SwitchPreferenceCompat, SwitchPreference, PreferenceCategory. For FQCN customs, construct the class directly or subclass StepOSPreference.");
            default:
                throw new IllegalArgumentException("Unknown preference short name \"" + name + "\". Supported: Preference, SwitchPreferenceCompat, SwitchPreference, PreferenceCategory. For FQCN customs, construct the class directly or subclass StepOSPreference.");
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0088, code lost:
    
        if (r0.equals("SwitchPreferenceCompat") != false) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final androidx.preference.Preference create(android.content.Context r9, java.lang.Class<? extends androidx.preference.Preference> r10, android.util.AttributeSet r11) {
        /*
            java.lang.String r0 = "context"
            kotlin.jvm.internal.p.i(r9, r0)
            java.lang.String r0 = "clazz"
            kotlin.jvm.internal.p.i(r10, r0)
            java.lang.Class<com.stepos.widget.preference.StepOSPreference> r0 = com.stepos.widget.preference.StepOSPreference.class
            boolean r0 = kotlin.jvm.internal.p.d(r10, r0)
            if (r0 != 0) goto L1a
            java.lang.Class<androidx.preference.Preference> r0 = androidx.preference.Preference.class
            boolean r0 = kotlin.jvm.internal.p.d(r10, r0)
            if (r0 == 0) goto L1e
        L1a:
            r3 = r9
            r4 = r11
            goto Lc6
        L1e:
            java.lang.Class<com.stepos.widget.preference.StepOSSwitchPreference> r0 = com.stepos.widget.preference.StepOSSwitchPreference.class
            boolean r0 = kotlin.jvm.internal.p.d(r10, r0)
            if (r0 != 0) goto L2e
            java.lang.Class<androidx.preference.SwitchPreferenceCompat> r0 = androidx.preference.SwitchPreferenceCompat.class
            boolean r0 = kotlin.jvm.internal.p.d(r10, r0)
            if (r0 == 0) goto L32
        L2e:
            r3 = r9
            r4 = r11
            goto Lbb
        L32:
            java.lang.Class<com.stepos.widget.preference.StepOSPreferenceCategory> r0 = com.stepos.widget.preference.StepOSPreferenceCategory.class
            boolean r0 = kotlin.jvm.internal.p.d(r10, r0)
            if (r0 != 0) goto L42
            java.lang.Class<androidx.preference.PreferenceCategory> r0 = androidx.preference.PreferenceCategory.class
            boolean r0 = kotlin.jvm.internal.p.d(r10, r0)
            if (r0 == 0) goto L46
        L42:
            r3 = r9
            r4 = r11
            goto Lb5
        L46:
            java.lang.String r0 = r10.getSimpleName()
            int r1 = r0.hashCode()
            switch(r1) {
                case 190073777: goto L80;
                case 533633275: goto L6b;
                case 889856847: goto L60;
                case 2041351961: goto L52;
                default: goto L51;
            }
        L51:
            goto L95
        L52:
            java.lang.String r1 = "PreferenceCategory"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L95
            com.stepos.widget.preference.StepOSPreferenceCategory r10 = new com.stepos.widget.preference.StepOSPreferenceCategory
            r10.<init>(r9, r11)
            return r10
        L60:
            java.lang.String r1 = "SwitchPreference"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L95
            r3 = r9
            r4 = r11
            goto L8a
        L6b:
            java.lang.String r1 = "Preference"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L95
            com.stepos.widget.preference.StepOSPreference r1 = new com.stepos.widget.preference.StepOSPreference
            r6 = 12
            r7 = 0
            r4 = 0
            r5 = 0
            r2 = r9
            r3 = r11
            r1.<init>(r2, r3, r4, r5, r6, r7)
            return r1
        L80:
            r3 = r9
            r4 = r11
            java.lang.String r9 = "SwitchPreferenceCompat"
            boolean r9 = r0.equals(r9)
            if (r9 == 0) goto L95
        L8a:
            com.stepos.widget.preference.StepOSSwitchPreference r2 = new com.stepos.widget.preference.StepOSSwitchPreference
            r7 = 12
            r8 = 0
            r5 = 0
            r6 = 0
            r2.<init>(r3, r4, r5, r6, r7, r8)
            return r2
        L95:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.String r10 = r10.getName()
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r0 = "Unsupported preference class "
            r11.append(r0)
            r11.append(r10)
            java.lang.String r10 = ". Use StepOSPreference / StepOSSwitchPreference / StepOSPreferenceCategory, or create(context, shortName)."
            r11.append(r10)
            java.lang.String r10 = r11.toString()
            r9.<init>(r10)
            throw r9
        Lb5:
            com.stepos.widget.preference.StepOSPreferenceCategory r9 = new com.stepos.widget.preference.StepOSPreferenceCategory
            r9.<init>(r3, r4)
            return r9
        Lbb:
            com.stepos.widget.preference.StepOSSwitchPreference r2 = new com.stepos.widget.preference.StepOSSwitchPreference
            r7 = 12
            r8 = 0
            r5 = 0
            r6 = 0
            r2.<init>(r3, r4, r5, r6, r7, r8)
            return r2
        Lc6:
            com.stepos.widget.preference.StepOSPreference r2 = new com.stepos.widget.preference.StepOSPreference
            r7 = 12
            r8 = 0
            r5 = 0
            r6 = 0
            r2.<init>(r3, r4, r5, r6, r7, r8)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.widget.preference.StepOSPreferenceFactory.create(android.content.Context, java.lang.Class, android.util.AttributeSet):androidx.preference.Preference");
    }
}
