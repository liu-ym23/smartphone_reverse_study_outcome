package l;

import android.os.Handler;
import f1.AbstractC0557a;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: l.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0746d extends AbstractC0557a {

    /* renamed from: i, reason: collision with root package name */
    public final Object f13418i = new Object();

    /* renamed from: j, reason: collision with root package name */
    public final ExecutorService f13419j = Executors.newFixedThreadPool(4, new ThreadFactoryC0745c());

    /* renamed from: k, reason: collision with root package name */
    public volatile Handler f13420k;
}
