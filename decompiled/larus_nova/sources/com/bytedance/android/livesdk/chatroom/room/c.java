package com.bytedance.android.livesdk.chatroom.room;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.livesdk.config.r90;
import com.bytedance.android.livesdk.config.s90;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes7.dex */
public final class c {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f110976l = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f110977a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f110978b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f110979c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f110980d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f110981e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f110982f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f110983g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final MutableLiveData<Boolean> f110984h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final MutableLiveData<Boolean> f110985i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final MutableLiveData<Integer> f110986j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f110987k;

    public static final class a {
        @JvmStatic
        public static boolean a() {
            return r90.f121114a.getValue().booleanValue();
        }
    }

    static {
    }

    public final void b() {
        this.f110978b = 0;
        this.f110979c = -1;
        this.f110980d = false;
        this.f110982f = false;
        this.f110983g = false;
        this.f110981e = false;
    }

    public c() {
        this.f110977a = new CompositeDisposable();
        this.f110979c = -1;
        this.f110984h = new MutableLiveData();
        this.f110985i = new MutableLiveData();
        this.f110986j = new MutableLiveData();
        this.f110987k = "normal";
    }

    public final <T> void a(Class<T> r100, Consumer<T> r101) {
        CompositeDisposable r102 = this.f110977a;
        if (r102 == null) goto L6;
        r102.add(xs2.b.a().b(r100).observeOn(AndroidSchedulers.mainThread()).subscribe(r101));
        return;
    }

    public final void c(boolean r100, boolean r101) {
        if (r100 == false) goto L4;
        this.f110982f = r100;
    L4:
        if (r101 == false) goto L7;
        this.f110983g = r101;
    L7:
        if (s90.f121191a.getValue().booleanValue() == false) goto L14;
        if (this.f110981e == true) goto L11;
        return;
    L11:
        if (this.f110983g == false) goto L22;
        this.f110985i.setValue(Boolean.TRUE);
        b();
        return;
    L22:
        return;
    L14:
        if (this.f110981e == true) goto L16;
        return;
    L16:
        if (this.f110982f == true) goto L18;
        return;
    L18:
        if (this.f110983g == false) goto L26;
        this.f110985i.setValue(Boolean.TRUE);
        b();
        return;
    }
}
