package com.bytedance.android.annie.lynx.resource;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/annie/lynx/resource/VerifyTemplateType;", "", "", "TYPE", "Ljava/lang/String;", "getTYPE", "()Ljava/lang/String;", "EMPTY_FILE", "BROKEN_FILE", "VERIFY_SUCCEED", "annie-lynx_release"}, k = 1, mv = {1, 4, 3})
public final enum VerifyTemplateType extends Enum<VerifyTemplateType> {
    public static final VerifyTemplateType BROKEN_FILE = null;
    public static final VerifyTemplateType EMPTY_FILE = null;
    public static final VerifyTemplateType VERIFY_SUCCEED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VerifyTemplateType[] f39506a = null;
    private final String TYPE;

    public static VerifyTemplateType valueOf(String r100) {
        return (VerifyTemplateType) r27.a.a(VerifyTemplateType.class, r100);
    }

    public static VerifyTemplateType[] values() {
        return (VerifyTemplateType[]) f39506a.clone();
    }

    static {
        VerifyTemplateType r100 = new VerifyTemplateType("EMPTY_FILE", 0, "Empty file");
        EMPTY_FILE = r100;
        VerifyTemplateType r101 = new VerifyTemplateType("BROKEN_FILE", 1, "Broken file");
        BROKEN_FILE = r101;
        VerifyTemplateType r102 = new VerifyTemplateType("VERIFY_SUCCEED", 2, "Verify succeed");
        VERIFY_SUCCEED = r102;
        f39506a = new VerifyTemplateType[]{r100, r101, r102};
    }

    public final String getTYPE() {
        return this.TYPE;
    }

    public VerifyTemplateType(String r100, int r101, String r102) {
        super(r100, r101);
        this.TYPE = r102;
    }
}
