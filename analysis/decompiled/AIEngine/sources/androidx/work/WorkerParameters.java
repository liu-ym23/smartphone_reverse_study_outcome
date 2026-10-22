package androidx.work;

import android.net.Network;
import android.net.Uri;
import h2.t;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import kotlinx.coroutines.CoroutineDispatcher;
import r2.p;
import r2.q;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class WorkerParameters {

    /* renamed from: a, reason: collision with root package name */
    public UUID f2801a;

    /* renamed from: b, reason: collision with root package name */
    public Data f2802b;

    /* renamed from: c, reason: collision with root package name */
    public HashSet f2803c;

    /* renamed from: d, reason: collision with root package name */
    public a f2804d;

    /* renamed from: e, reason: collision with root package name */
    public int f2805e;

    /* renamed from: f, reason: collision with root package name */
    public ExecutorService f2806f;

    /* renamed from: g, reason: collision with root package name */
    public CoroutineDispatcher f2807g;
    public s2.c h;

    /* renamed from: i, reason: collision with root package name */
    public t f2808i;

    /* renamed from: j, reason: collision with root package name */
    public q f2809j;

    /* renamed from: k, reason: collision with root package name */
    public p f2810k;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public List<String> f2811a;

        /* renamed from: b, reason: collision with root package name */
        public List<Uri> f2812b;

        /* renamed from: c, reason: collision with root package name */
        public Network f2813c;

        public a() {
            List list = Collections.EMPTY_LIST;
            this.f2811a = list;
            this.f2812b = list;
        }
    }

    public WorkerParameters() {
        throw null;
    }
}
