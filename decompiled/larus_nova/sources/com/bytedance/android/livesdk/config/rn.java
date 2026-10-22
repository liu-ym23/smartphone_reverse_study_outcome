package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class rn extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final rn f121144a = null;

    static {
        f121144a = new rn();
    }

    public rn() {
        Boolean r100 = Boolean.TRUE;
        super("live_digg_widget_preview_no_obtain_drawable_ids", "DiggWidget.onInit在预览流不重复读取drawable id", r100, r100);
    }
}
