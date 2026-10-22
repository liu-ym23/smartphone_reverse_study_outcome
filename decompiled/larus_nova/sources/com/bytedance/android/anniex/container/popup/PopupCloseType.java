package com.bytedance.android.anniex.container.popup;

import com.bytedance.ies.bullet.service.base.h;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002H&R\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0005\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/anniex/container/popup/PopupCloseType;", "", "", "enableFix", "", "getTag", "tag", "Ljava/lang/String;", "()Ljava/lang/String;", "SYSTEM_BACK", "PULL_DOWN", "CLICK_MASK", "UNKNOWN", "anniex_release"}, k = 1, mv = {1, 4, 3})
public abstract enum PopupCloseType extends Enum<PopupCloseType> {
    public static final PopupCloseType CLICK_MASK = null;
    public static final PopupCloseType PULL_DOWN = null;
    public static final PopupCloseType SYSTEM_BACK = null;
    public static final PopupCloseType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PopupCloseType[] f40455a = null;
    private final String tag;

    public PopupCloseType() {
        throw null;
    }

    public static PopupCloseType valueOf(String r100) {
        return (PopupCloseType) r27.a.a(PopupCloseType.class, r100);
    }

    public static PopupCloseType[] values() {
        return (PopupCloseType[]) f40455a.clone();
    }

    public abstract String getTag(boolean r100);

    static {
        final String r100 = "SYSTEM_BACK";
        final int r101 = 0;
        PopupCloseType r102 = new SYSTEM_BACK(r100, r101);
        SYSTEM_BACK = r102;
        final String r103 = "PULL_DOWN";
        final int r104 = 1;
        PopupCloseType r105 = new PULL_DOWN(r103, r104);
        PULL_DOWN = r105;
        final String r106 = "CLICK_MASK";
        final int r107 = 2;
        PopupCloseType r108 = new CLICK_MASK(r106, r107);
        CLICK_MASK = r108;
        final String r109 = "UNKNOWN";
        final int r110 = 3;
        PopupCloseType r111 = new UNKNOWN(r109, r110);
        UNKNOWN = r111;
        f40455a = new PopupCloseType[]{r102, r105, r108, r111};
    }

    public final String getTag() {
        return this.tag;
    }

    public PopupCloseType(String r100, int r101, String r102, DefaultConstructorMarker r103) {
        super(r100, r101);
        this.tag = r102;
    }

    public static /* synthetic */ String getTag$default(PopupCloseType r100, boolean r101, int r102, Object r103) {
        if (r103 != null) goto L9;
        if ((r102 & 1) == 0) goto L7;
        r101 = h.r();
    L7:
        return r100.getTag(r101);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getTag");
    }
}
