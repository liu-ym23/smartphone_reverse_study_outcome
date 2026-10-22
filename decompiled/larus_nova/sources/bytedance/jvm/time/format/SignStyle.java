package bytedance.jvm.time.format;

import com.ss.android.ugc.effectmanager.common.EffectConstants;

/* JADX INFO: loaded from: classes28.dex */
public final enum SignStyle extends Enum<SignStyle> {
    public static final SignStyle ALWAYS = null;
    public static final SignStyle EXCEEDS_PAD = null;
    public static final SignStyle NEVER = null;
    public static final SignStyle NORMAL = null;
    public static final SignStyle NOT_NEGATIVE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SignStyle[] f21639a = null;

    static {
        SignStyle r100 = new SignStyle(EffectConstants.NORMAL, 0);
        NORMAL = r100;
        SignStyle r101 = new SignStyle("ALWAYS", 1);
        ALWAYS = r101;
        SignStyle r102 = new SignStyle("NEVER", 2);
        NEVER = r102;
        SignStyle r103 = new SignStyle("NOT_NEGATIVE", 3);
        NOT_NEGATIVE = r103;
        SignStyle r104 = new SignStyle("EXCEEDS_PAD", 4);
        EXCEEDS_PAD = r104;
        f21639a = new SignStyle[]{r100, r101, r102, r103, r104};
    }

    public static SignStyle[] values() {
        return (SignStyle[]) f21639a.clone();
    }

    public static SignStyle valueOf(String r100) {
        return (SignStyle) r27.a.a(SignStyle.class, r100);
    }

    public SignStyle(String r100, int r101) {
        super(r100, r101);
    }

    public boolean parse(boolean r100, boolean r101, boolean r102) {
        int r103 = ordinal();
        if (r103 == 0) goto L12;
        if (r103 != 1) goto L6;
    L11:
        return true;
    L6:
        if (r103 == 4) goto L11;
        if (r101 == true) goto L16;
        if (r102 == true) goto L17;
        return true;
    L17:
        return false;
    L16:
        return false;
    L12:
        if (r100 == false) goto L14;
        if (r101 == false) goto L14;
        return false;
    L14:
        return true;
    }
}
