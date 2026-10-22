package com.bytedance.android.live.room.api.messagewindow.builder.card;

import android.content.Context;
import com.bytedance.android.live.room.api.messagewindow.constraint.CardConstraint;
import com.bytedance.android.live.room.api.messagewindow.container.MsgWindowPosition;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import x61.h;

/* JADX INFO: loaded from: classes47.dex */
public final class CardMountingsBuilder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DataCenter f98923a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f98924b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f98925c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f98926d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public MsgWindowPosition f98927e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function1<? super ContainerBuilder, Unit> f98928f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Function1<? super b, Unit> f98929g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function1<? super d, Unit> f98930h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Function1<? super a, Unit> f98931i;

    public static final class ContainerBuilder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Function0<? extends h<?, ?>> f98932a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final CardConstraint f98933b;

        public ContainerBuilder() {
            this.f98932a = CardMountingsBuilder$ContainerBuilder$content$1.INSTANCE;
            this.f98933b = new CardConstraint(-2, -2);
        }
    }

    public static final class a {
        public a() {
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Function0<Unit> f98934a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Function0<Unit> f98935b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Function0<Unit> f98936c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Function0<Unit> f98937d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final v61.a f98938e;

        public b(v61.a r100) {
            Intrinsics.checkNotNullParameter(r100, BrowserDependency.UrlClickType.CARD);
            this.f98938e = r100;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f98939a = null;

        public c() {
        }

        static {
            f98939a = new c();
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<t71.a> f98940a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<t71.a> f98941b;

        public d() {
            ArrayList r100 = new ArrayList();
            this.f98940a = r100;
            this.f98941b = r100;
        }
    }

    public CardMountingsBuilder() {
        this.f98925c = c.f98939a;
        this.f98926d = Integer.MIN_VALUE;
        this.f98927e = MsgWindowPosition.BOTTOM_RIGHT;
        this.f98928f = CardMountingsBuilder$containerBuilderInit$1.INSTANCE;
        this.f98929g = CardMountingsBuilder$lifeCycleBuilderInit$1.INSTANCE;
        this.f98930h = CardMountingsBuilder$strategyBuilderInit$1.INSTANCE;
        this.f98931i = CardMountingsBuilder$argsBuilderInit$1.INSTANCE;
    }

    public static void a(CardMountingsBuilder r100, DataCenter r101, Object r102, int r103, MsgWindowPosition r104, int r105) {
        if ((r105 & 16) == 0) goto L5;
        r104 = MsgWindowPosition.BOTTOM_RIGHT;
    L5:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r102, DownloadHelper.IDENTITY);
        Intrinsics.checkNotNullParameter(r104, "position");
        r100.f98923a = r101;
        r100.f98925c = r102;
        r100.f98926d = r103;
        r100.f98924b = null;
        r100.f98927e = r104;
    }
}
