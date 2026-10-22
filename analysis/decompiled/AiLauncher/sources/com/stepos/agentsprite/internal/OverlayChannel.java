package com.stepos.agentsprite.internal;

import Ua.C1060i;
import Ua.M;
import Xa.d;
import Xa.k;
import Xa.u;
import Y8.t;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import kotlinx.coroutines.g;
import p9.p;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B1\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u0012\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\u0011\u001a\u00020\b2\u0006\u0010\f\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\b¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\b2\u0006\u0010\f\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R&\u0010\t\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001d\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000\u001f8\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0016\u0010'\u001a\u00028\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010*\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010,\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010+R\u0016\u0010-\u001a\u00028\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010&R\u0018\u00100\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010/R\u0014\u00101\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010&¨\u00062"}, d2 = {"Lcom/stepos/agentsprite/internal/OverlayChannel;", ExifInterface.GPS_DIRECTION_TRUE, "", "LUa/M;", "scope", "initial", "Lkotlin/Function2;", "", "LY8/t;", "onPublish", "<init>", "(LUa/M;Ljava/lang/Object;Lp9/p;)V", UxipConstants.f30680s, "", "holdMillis", "", "priority", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/lang/Object;JI)V", Const.INTENT_KEY_BACKGROUND_COMMAND, "()V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/lang/Object;)V", Const.INTENT_KEY_APIKEY, "LUa/M;", Const.INTENT_KEY_PKGNAME, "Lp9/p;", "LXa/k;", "c", "LXa/k;", "flowMut", "LXa/t;", Const.INTENT_KEY_UMID, "LXa/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()LXa/t;", "flow", "e", "Ljava/lang/Object;", "base", "f", "Z", "transientActive", "I", "transientPriority", "lastPublished", "Lkotlinx/coroutines/g;", "Lkotlinx/coroutines/g;", "transientJob", "lock", "agentsprite_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class OverlayChannel<T> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final M scope;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final p<T, Boolean, t> onPublish;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final k<T> flowMut;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final Xa.t<T> flow;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public volatile T base;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public volatile boolean transientActive;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public volatile int transientPriority;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public T lastPublished;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public g transientJob;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public final Object lock;

    /* JADX WARN: Multi-variable type inference failed */
    public OverlayChannel(M scope, T t10, p<? super T, ? super Boolean, t> onPublish) {
        kotlin.jvm.internal.p.i(scope, "scope");
        kotlin.jvm.internal.p.i(onPublish, "onPublish");
        this.scope = scope;
        this.onPublish = onPublish;
        k<T> kVarA = u.a(t10);
        this.flowMut = kVarA;
        this.flow = d.c(kVarA);
        this.base = t10;
        this.lastPublished = t10;
        this.lock = new Object();
        onPublish.invoke(t10, Boolean.FALSE);
    }

    public final void g() {
        g gVar = this.transientJob;
        if (gVar != null) {
            g.Y0(gVar, null, 1, null);
        }
        this.transientJob = null;
    }

    public final Xa.t<T> h() {
        return this.flow;
    }

    public final void i(T value) {
        boolean zD = kotlin.jvm.internal.p.d(value, this.lastPublished);
        this.lastPublished = value;
        this.flowMut.setValue(value);
        this.onPublish.invoke(value, Boolean.valueOf(zD));
    }

    public final void j(T value, long holdMillis, int priority) {
        synchronized (this.lock) {
            try {
                if (holdMillis <= 0) {
                    g gVar = this.transientJob;
                    if (gVar != null) {
                        g.Y0(gVar, null, 1, null);
                    }
                    this.transientJob = null;
                    this.base = value;
                    this.transientActive = false;
                    i(value);
                    return;
                }
                if (!this.transientActive || priority >= this.transientPriority) {
                    g gVar2 = this.transientJob;
                    if (gVar2 != null) {
                        g.Y0(gVar2, null, 1, null);
                    }
                    this.transientJob = null;
                    this.transientActive = true;
                    this.transientPriority = priority;
                    i(value);
                    this.transientJob = C1060i.d(this.scope, null, null, new OverlayChannel$set$1$1(holdMillis, this, null), 3, null);
                    t tVar = t.f7040a;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
