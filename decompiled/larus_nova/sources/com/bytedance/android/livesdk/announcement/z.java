package com.bytedance.android.livesdk.announcement;

/* JADX INFO: loaded from: classes7.dex */
public final class z implements c1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnnouncementSettingDialog2 f103660a;

    @Override // com.bytedance.android.livesdk.announcement.c1
    public final void a() {
        AnnouncementSettingDialog2 r100 = this.f103660a;
        if (r100.f103246v == true) goto L5;
        String r101 = rm3.c.f538539a;
        rm3.c.g(r100.getContext(), "最多输入" + this.f103660a.f103243s + "个字符", 0, false, 28);
    L5:
        this.f103660a.f103246v = true;
    }

    public z(AnnouncementSettingDialog2 r100) {
        this.f103660a = r100;
    }
}
