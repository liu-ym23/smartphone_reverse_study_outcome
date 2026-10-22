package com.bytedance.android.annie.api.resource;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/annie/api/resource/AnnieResType;", "", "", "tag", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "LYNX_TEMPLATE", "WEB_MAIN_RESOURCE", "COMPONENT", "EXTERNAL_JS", "STATIC", "LYNX_CHILD_RESOURCE", "LYNX_IMAGE", "LYNX_FONT", "WEB_CHILD_RESOURCE", "PRELOAD_CONFIG", "UNKNOWN", "annie-api_release"}, k = 1, mv = {1, 4, 3})
public final enum AnnieResType extends Enum<AnnieResType> {
    public static final AnnieResType COMPONENT = null;
    public static final AnnieResType EXTERNAL_JS = null;
    public static final AnnieResType LYNX_CHILD_RESOURCE = null;
    public static final AnnieResType LYNX_FONT = null;
    public static final AnnieResType LYNX_IMAGE = null;
    public static final AnnieResType LYNX_TEMPLATE = null;
    public static final AnnieResType PRELOAD_CONFIG = null;
    public static final AnnieResType STATIC = null;
    public static final AnnieResType UNKNOWN = null;
    public static final AnnieResType WEB_CHILD_RESOURCE = null;
    public static final AnnieResType WEB_MAIN_RESOURCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AnnieResType[] f38412a = null;
    private final String tag;

    public static AnnieResType valueOf(String r100) {
        return (AnnieResType) a.a(AnnieResType.class, r100);
    }

    public static AnnieResType[] values() {
        return (AnnieResType[]) f38412a.clone();
    }

    static {
        AnnieResType r100 = new AnnieResType("LYNX_TEMPLATE", 0, "lynx_template");
        LYNX_TEMPLATE = r100;
        AnnieResType r101 = new AnnieResType("WEB_MAIN_RESOURCE", 1, "web_main_resource");
        WEB_MAIN_RESOURCE = r101;
        AnnieResType r102 = new AnnieResType("COMPONENT", 2, "component");
        COMPONENT = r102;
        AnnieResType r103 = new AnnieResType("EXTERNAL_JS", 3, "external_js");
        EXTERNAL_JS = r103;
        AnnieResType r104 = new AnnieResType("STATIC", 4, "static");
        STATIC = r104;
        AnnieResType r105 = new AnnieResType("LYNX_CHILD_RESOURCE", 5, "lynx_child_resource");
        LYNX_CHILD_RESOURCE = r105;
        AnnieResType r110 = new AnnieResType("LYNX_IMAGE", 6, "lynx_image");
        LYNX_IMAGE = r110;
        AnnieResType r111 = new AnnieResType("LYNX_FONT", 7, "lynx_font");
        LYNX_FONT = r111;
        AnnieResType r112 = new AnnieResType("WEB_CHILD_RESOURCE", 8, "web_child_resource");
        WEB_CHILD_RESOURCE = r112;
        AnnieResType r113 = new AnnieResType("PRELOAD_CONFIG", 9, "preload_config");
        PRELOAD_CONFIG = r113;
        AnnieResType r114 = new AnnieResType("UNKNOWN", 10, "unknown");
        UNKNOWN = r114;
        f38412a = new AnnieResType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114};
    }

    public final String getTag() {
        return this.tag;
    }

    public AnnieResType(String r100, int r101, String r102) {
        super(r100, r101);
        this.tag = r102;
    }
}
