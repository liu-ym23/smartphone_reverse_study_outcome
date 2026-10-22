package androidx.media;

import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public abstract class VolumeProviderCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3712a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3713b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3714c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Callback f3715d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object f3716e;

    public static abstract class Callback {
        public Callback() {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface ControlType {
    }

    public class a implements VolumeProviderCompatApi21.Delegate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VolumeProviderCompat f3717a;

        public a(VolumeProviderCompat r10) {
            this.f3717a = r10;
        }

        @Override // androidx.media.VolumeProviderCompatApi21.Delegate
        public void onAdjustVolume(int r10) {
            this.f3717a.e(r10);
        }

        @Override // androidx.media.VolumeProviderCompatApi21.Delegate
        public void onSetVolumeTo(int r10) {
            this.f3717a.f(r10);
        }
    }

    public final int a() {
        return this.f3714c;
    }

    public final int b() {
        return this.f3713b;
    }

    public final int c() {
        return this.f3712a;
    }

    public Object d() {
        if (this.f3716e != null) goto L6;
        this.f3716e = VolumeProviderCompatApi21.a(this.f3712a, this.f3713b, this.f3714c, new a(this));
    L6:
        return this.f3716e;
    }

    public void e(int r10) {
    }

    public void f(int r10) {
    }

    public void g(Callback r10) {
        this.f3715d = r10;
    }
}
