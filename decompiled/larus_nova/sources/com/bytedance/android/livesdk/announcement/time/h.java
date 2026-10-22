package com.bytedance.android.livesdk.announcement.time;

/* JADX INFO: loaded from: classes7.dex */
public final class h implements AnnouncementTimeSelectWidget.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnnouncementTimeSettingDialog f103591a;

    @Override // com.bytedance.android.livesdk.announcement.time.AnnouncementTimeSelectWidget.a
    public final void a() {
        AnnouncementTimeSettingDialog r100 = this.f103591a;
        if (r100.f103576i == null) goto L9;
        com.bytedance.android.livesdk.announce.b r101 = ((AnnouncementTimeSelectWidget) r100.f103577j.getValue()).wq();
        com.bytedance.android.livesdk.announce.b r102 = this.f103591a.f103576i;
        if (r102 != null) goto L8;
    L10:
        boolean r103 = false;
    L11:
        this.f103591a.U90(r103);
        return;
    L8:
        if (r102.equals(r101) == true) goto L10;
    L9:
        r103 = true;
        goto L11
    }

    public h(AnnouncementTimeSettingDialog r100) {
        this.f103591a = r100;
    }
}
