package com.bytedance.android.live.saas.middleware.login.imp;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.live.saas.middleware.login.ILogin;
import com.tencent.qqmusic.third.api.contract.Keys;
import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import kotlin.Metadata;
import kotlin.Pair;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\u0005H\u0016J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\nH\u0016J\u0006\u0010\u000b\u001a\u00020\fJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u0006\u0010\u000f\u001a\u00020\fJ\u0012\u0010\u0010\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005H\u0016J,\u0010\u0012\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u0001H\u0014\u0012\u0004\u0012\u0002H\u00140\u00130\n\"\u0004\b\u0000\u0010\u0014*\b\u0012\u0004\u0012\u0002H\u00140\nH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/login/imp/LoginStatusStub;", "Lcom/bytedance/android/live/saas/middleware/login/ILogin;", "", "()V", "currentAuthUserOpenId", "", "ob", "Lio/reactivex/subjects/PublishSubject;", "getUid", "getUidObservable", "Lio/reactivex/Observable;", "init", "", Keys.API_RETURN_KEY_IS_LOGIN, "", "unInit", "updateCurrentAuthUserOpenId", "openId", "diffCompat", "Lkotlin/Pair;", ExifInterface.GPS_DIRECTION_TRUE, "middleware_release"}, k = 1, mv = {1, 4, 3})
public final class LoginStatusStub implements ILogin<Object> {
    public static final LoginStatusStub INSTANCE = null;
    private static String currentAuthUserOpenId;

    /* JADX INFO: renamed from: ob, reason: collision with root package name */
    private static PublishSubject<String> f100465ob;

    private LoginStatusStub() {
    }

    public final void init() {
    }

    static {
        INSTANCE = new LoginStatusStub();
        f100465ob = PublishSubject.create();
        currentAuthUserOpenId = "";
    }

    @Override // com.bytedance.android.live.saas.middleware.login.ILogin
    public Observable<String> getUidObservable() {
        return diffCompat(f100465ob).filter(C99581.INSTANCE).map(AnonymousClass2.INSTANCE);
    }

    @Override // com.bytedance.android.live.saas.middleware.login.ILogin
    public boolean isLogin() {
        if (currentAuthUserOpenId.length() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final void unInit() {
        f100465ob.onComplete();
    }

    @Override // com.bytedance.android.live.saas.middleware.login.ILogin
    public String getUid() {
        return currentAuthUserOpenId;
    }

    private final <T> Observable<Pair<T, T>> diffCompat(final Observable<T> r100) {
        return Observable.defer(new AnonymousClass1(r100));
    }

    @Override // com.bytedance.android.live.saas.middleware.login.ILogin
    public void updateCurrentAuthUserOpenId(String r100) {
        if (r100 != null) goto L4;
        r100 = "";
    L4:
        currentAuthUserOpenId = r100;
        f100465ob.onNext(r100);
    }
}
