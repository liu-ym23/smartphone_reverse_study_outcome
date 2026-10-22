package com.bytedance.android.annie.api.param;

import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/annie/api/param/AnnieViewType;", "", "", "tag", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "CARD", "POPUP", "FULLSCREEN", "annie-api_release"}, k = 1, mv = {1, 4, 3})
public final enum AnnieViewType extends Enum<AnnieViewType> {
    public static final AnnieViewType CARD = null;
    public static final AnnieViewType FULLSCREEN = null;
    public static final AnnieViewType POPUP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AnnieViewType[] f38411a = null;
    private final String tag;

    public static AnnieViewType valueOf(String r100) {
        return (AnnieViewType) a.a(AnnieViewType.class, r100);
    }

    public static AnnieViewType[] values() {
        return (AnnieViewType[]) f38411a.clone();
    }

    static {
        AnnieViewType r100 = new AnnieViewType("CARD", 0, BrowserDependency.UrlClickType.CARD);
        CARD = r100;
        AnnieViewType r101 = new AnnieViewType("POPUP", 1, "popup");
        POPUP = r101;
        AnnieViewType r102 = new AnnieViewType("FULLSCREEN", 2, "page");
        FULLSCREEN = r102;
        f38411a = new AnnieViewType[]{r100, r101, r102};
    }

    public final String getTag() {
        return this.tag;
    }

    public AnnieViewType(String r100, int r101, String r102) {
        super(r100, r101);
        this.tag = r102;
    }
}
