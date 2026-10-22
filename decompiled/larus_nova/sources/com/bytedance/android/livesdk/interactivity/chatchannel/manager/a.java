package com.bytedance.android.livesdk.interactivity.chatchannel.manager;

import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdkapi.message.BaseMessage;
import java.util.LinkedList;
import java.util.ListIterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a<T extends BaseMessage> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedList<l62.a<T>> f134263a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f134264b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f134265c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final IAssetsManager f134266d;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.chatchannel.manager.a$a, reason: collision with other inner class name */
    public static final class C2119a {
    }

    public interface b<T extends BaseMessage> {
        void a(l62.a<T> r100);
    }

    public static final class c extends com.bytedance.android.livesdk.gift.platform.business.effect.assets.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public b<T> f134267a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f134268b;

        @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.o, com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
        public final void a(long r100) {
        }

        @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.o, com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
        public final void b(boolean r100) {
        }

        @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.o
        public final String d() {
            return "AssetFetcher";
        }

        @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.o, com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
        public final void onFailed(Throwable r100) {
            Intrinsics.checkNotNullParameter(r100, "t");
        }

        @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.o, com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
        public final void onProgress(int r100) {
        }

        public c(a r100) {
            this.f134268b = r100;
        }

        @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.o, com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
        public final void c(long r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "path");
            super.c(r100, r101);
            LinkedList<l62.a<T>> r102 = this.f134268b.f134263a;
            ListIterator<l62.a<T>> r103 = r102.listIterator(r102.size());
        L4:
            if (r103.hasPrevious() == false) goto L11;
            l62.a<T> r104 = r103.previous();
            if (r104.f507658a != r100) goto L8;
            boolean r105 = true;
        L9:
            if (r105 == false) goto L4;
        L12:
            l62.a<T> r106 = r104;
            if (r106 != null) goto L16;
            return;
        L16:
            if ((!this.f134268b.f134263a.isEmpty()) == false) goto L20;
            if (Intrinsics.areEqual(this.f134268b.f134263a.removeFirst(), r106) == false) goto L16;
        L20:
            if ((System.currentTimeMillis() - r106.f507660c) >= 3000) goto L33;
            Intrinsics.checkNotNullParameter(r101, "<set-?>");
            r106.f507659b = r101;
            b<T> r107 = this.f134267a;
            if (r107 == null) goto L34;
            r107.a(r106);
            return;
        L34:
            return;
        L33:
            return;
        L8:
            r105 = false;
            goto L9
        L11:
            r104 = null;
            goto L12
        }
    }

    static {
    }

    public a(boolean r100, IAssetsManager r101) {
        Intrinsics.checkNotNullParameter(r101, "assetManager");
        this.f134265c = r100;
        this.f134266d = r101;
        this.f134263a = new LinkedList();
        this.f134264b = new c(this);
    }
}
