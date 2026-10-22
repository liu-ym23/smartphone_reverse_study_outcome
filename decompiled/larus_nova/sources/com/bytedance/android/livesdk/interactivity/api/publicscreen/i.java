package com.bytedance.android.livesdk.interactivity.api.publicscreen;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.interactivity.api.entity.DisplayTimeRecorder;
import com.bytedance.android.livesdk.interactivity.api.entity.PSMessageAction;
import com.bytedance.android.livesdkapi.message.IPublicAreaCommon;

/* JADX INFO: loaded from: classes9.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f133470a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f133471b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PSMessageAction f133472c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public u42.b f133473d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Long f133474e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f133475f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Long f133476g;

    public interface a {
        z92.a a(com.bytedance.android.live.base.model.message.t r100);
    }

    public abstract j<? extends i, ? extends PSMessageViewHolder> b();

    public abstract IPublicAreaCommon c();

    public long d() {
        return 0;
    }

    public boolean e() {
        return false;
    }

    public abstract IBaseUser f();

    public boolean g() {
        return false;
    }

    public abstract PublicScreenConfig$MessageModelType getType();

    public boolean h() {
        return false;
    }

    public boolean i() {
        return false;
    }

    public DisplayTimeRecorder j() {
        return null;
    }

    public i() {
        this.f133472c = PSMessageAction.UNKNOW;
    }

    public PSMessageAction a() {
        return this.f133472c;
    }
}
