package com.obric.matrix.platform.sdk.ones.internal.tunnel;

import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import hc.b;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public abstract class MatrixEventObserver extends ContentObserver {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f11926e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11927a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f11928b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f11929c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f11930d;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    static {
        f11926e = new a(null);
    }

    public /* synthetic */ MatrixEventObserver(String r10, boolean r11, Handler r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = false;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = null;
    L8:
        this(r10, r11, r12);
    }

    public static final /* synthetic */ String a(MatrixEventObserver r10) {
        return r10.f11927a;
    }

    public final Uri b() {
        Object r10 = this.f11929c.getValue();
        q.f(r10, "<get-myUri>(...)");
        return (Uri) r10;
    }

    public abstract void c(Uri r10);

    @Override // android.database.ContentObserver
    public void onChange(boolean r10, Uri r11) {
        super.onChange(r10, r11);
        if (r11 != null) goto L5;
    L13:
        b.m("MatrixEventObserver", "onChange, ignore! uri: [" + r11 + "], registered: [" + this.f11930d + ']', null, 4, null);
        return;
    L5:
        if (this.f11930d == false) goto L13;
        b.b("MatrixEventObserver", "onChange, uri: [" + r11 + ']', null, 4, null);
        c(r11);     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        b.c("MatrixEventObserver", "onChange, error! myUri: " + b() + ", uri Changed: " + r11, e);
    }

    public MatrixEventObserver(String r10, boolean r11, Handler r12) {
        q.g(r10, "myPath");
        super(r12);
        this.f11927a = r10;
        this.f11928b = r11;
        this.f11929c = kotlin.b.b(new MatrixEventObserver$myUri$2(this));
    }
}
