package com.baidu.mshield.x6.f.m;

import android.annotation.TargetApi;
import com.baidu.mshield.x6.f.f;

@TargetApi(9)
/* loaded from: classes.dex */
public abstract class a implements d<a> {

    /* renamed from: a, reason: collision with root package name */
    public int f8525a;

    public a() {
        this(5);
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(a aVar) {
        try {
            return aVar.f8525a - this.f8525a;
        } catch (Throwable th) {
            f.b(th);
            return 0;
        }
    }

    public abstract void a();

    @Override // java.lang.Runnable
    public void run() {
        a();
    }

    public a(int i4) {
        this.f8525a = i4;
    }
}
