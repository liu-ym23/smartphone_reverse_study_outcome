package com.stepos.ailauncher.chat;

import La.H;
import Ua.C1056g;
import Ua.C1060i;
import Ua.J;
import Ua.Y;
import Z8.F;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.view.C1383a;
import android.view.S;
import android.webkit.MimeTypeMap;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import h8.C4148a;
import io.ktor.http.ContentType;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u0000 (2\u00020\u0001:\u0001)B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J_\u0010\u0015\u001a\u00020\u000e2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2$\u0010\u0014\u001a \u0012\u0004\u0012\u00020\u0011\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000e0\u0012\u0012\u0004\u0012\u00020\u000e0\u0010¢\u0006\u0004\b\u0015\u0010\u0016JW\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000e0\u00122$\u0010\u0014\u001a \u0012\u0004\u0012\u00020\u0011\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000e0\u0012\u0012\u0004\u0012\u00020\u000e0\u0010¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u000eH\u0014¢\u0006\u0004\b\u001a\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u000b*\u00020\tH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ$\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001f0\u001e2\u0006\u0010\u0017\u001a\u00020\u0007H\u0082@¢\u0006\u0004\b \u0010!J$\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u001e2\u0006\u0010\u0017\u001a\u00020\u0007H\u0082@¢\u0006\u0004\b\"\u0010!JL\u0010%\u001a\"\u0012\f\u0012\n $*\u0004\u0018\u00010\t0\t\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001f0\u001e0\u001e2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001f0\u001e2\u0006\u0010\u0017\u001a\u00020\u0007H\u0082@¢\u0006\u0004\b%\u0010&R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010'¨\u0006*"}, d2 = {"Lcom/stepos/ailauncher/chat/PickFileMediatorViewModel;", "Landroidx/lifecycle/a;", "Landroid/app/Application;", ContentType.Application.TYPE, "<init>", "(Landroid/app/Application;)V", "", "Landroid/net/Uri;", "uris", "", "resultAction", "", "isFromFakeMode", "Lkotlin/Function0;", "LY8/t;", "onHandleFinish", "Lkotlin/Function2;", "Lcom/stepos/ailauncher/chat/MainPagePreLoadAction;", "Lkotlin/Function1;", "Landroid/content/Intent;", "runInFakeModeBlock", "l", "(Ljava/util/List;Ljava/lang/String;ZLp9/a;Lp9/p;)V", "uri", "k", "(Landroid/net/Uri;ZLp9/l;Lp9/p;)V", Const.INTENT_KEY_UMID, "()V", "m", "(Ljava/lang/String;)Z", "Lkotlin/Pair;", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Landroid/net/Uri;Le9/c;)Ljava/lang/Object;", "o", "fileInfo", "kotlin.jvm.PlatformType", "n", "(Lkotlin/Pair;Landroid/net/Uri;Le9/c;)Ljava/lang/Object;", "Landroid/app/Application;", "Companion", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PickFileMediatorViewModel extends C1383a {
    private static final String TAG = "PickFileMediatorViewModel";
    private final Application application;

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"com/stepos/ailauncher/chat/PickFileMediatorViewModel$b", "Lkotlin/coroutines/a;", "LUa/J;", "Lkotlin/coroutines/d;", "context", "", "exception", "LY8/t;", "handleException", "(Lkotlin/coroutines/d;Ljava/lang/Throwable;)V", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b extends kotlin.coroutines.a implements J {
        final /* synthetic */ InterfaceC5074l $onHandleFinish$inlined;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(J.Companion companion, InterfaceC5074l interfaceC5074l) {
            super(companion);
            this.$onHandleFinish$inlined = interfaceC5074l;
        }

        @Override // Ua.J
        public void handleException(kotlin.coroutines.d context, Throwable exception) {
            C4148a.h(PickFileMediatorViewModel.TAG, String.valueOf(exception.getMessage()), false, 4, null);
            this.$onHandleFinish$inlined.invoke(Boolean.TRUE);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PickFileMediatorViewModel(Application application) {
        super(application);
        kotlin.jvm.internal.p.i(application, "application");
        this.application = application;
    }

    @Override // android.view.Q
    public void d() {
        super.d();
    }

    public final Object j(Uri uri, InterfaceC4014c<? super Pair<String, Integer>> interfaceC4014c) {
        return C1056g.j(Y.b(), new PickFileMediatorViewModel$acquireFileInfo$2(this, uri, null), interfaceC4014c);
    }

    public final void k(Uri uri, boolean isFromFakeMode, InterfaceC5074l<? super Boolean, Y8.t> onHandleFinish, p9.p<? super MainPagePreLoadAction, ? super InterfaceC5074l<? super Intent, Y8.t>, Y8.t> runInFakeModeBlock) {
        kotlin.jvm.internal.p.i(uri, "uri");
        kotlin.jvm.internal.p.i(onHandleFinish, "onHandleFinish");
        kotlin.jvm.internal.p.i(runInFakeModeBlock, "runInFakeModeBlock");
        C1060i.d(S.a(this), new b(J.INSTANCE, onHandleFinish), null, new PickFileMediatorViewModel$handleDocDataLegacy$2(this, uri, isFromFakeMode, runInFakeModeBlock, onHandleFinish, null), 2, null);
    }

    public final void l(List<? extends Uri> uris, String resultAction, boolean isFromFakeMode, InterfaceC5063a<Y8.t> onHandleFinish, p9.p<? super MainPagePreLoadAction, ? super InterfaceC5074l<? super Intent, Y8.t>, Y8.t> runInFakeModeBlock) {
        kotlin.jvm.internal.p.i(uris, "uris");
        kotlin.jvm.internal.p.i(resultAction, "resultAction");
        kotlin.jvm.internal.p.i(onHandleFinish, "onHandleFinish");
        kotlin.jvm.internal.p.i(runInFakeModeBlock, "runInFakeModeBlock");
        if (uris.isEmpty()) {
            onHandleFinish.invoke();
        } else {
            C1060i.d(S.a(this), null, null, new PickFileMediatorViewModel$handleImgData$1(uris, this, isFromFakeMode, runInFakeModeBlock, onHandleFinish, resultAction, null), 3, null);
        }
    }

    public final boolean m(String str) {
        List listB1 = H.b1(str, new String[]{"."}, false, 0, 6, null);
        if (listB1.size() < 2) {
            return false;
        }
        String lowerCase = ((String) F.C0(listB1)).toLowerCase(Locale.ROOT);
        kotlin.jvm.internal.p.h(lowerCase, "toLowerCase(...)");
        if (q.SUPPORTED_EXTENSIONS.contains(lowerCase)) {
            return true;
        }
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(lowerCase);
        if (mimeTypeFromExtension == null) {
            mimeTypeFromExtension = "";
        }
        return Z8.r.R(q.SUPPORTED_MIME_TYPES, mimeTypeFromExtension);
    }

    public final Object n(Pair<String, Integer> pair, Uri uri, InterfaceC4014c<? super Pair<String, Pair<String, Integer>>> interfaceC4014c) {
        return C1056g.j(Y.b(), new PickFileMediatorViewModel$performPersistence$2(pair, this, uri, null), interfaceC4014c);
    }

    public final Object o(Uri uri, InterfaceC4014c<? super Pair<String, String>> interfaceC4014c) {
        return C1056g.j(Y.b(), new PickFileMediatorViewModel$saveImg2File$2(this, uri, null), interfaceC4014c);
    }
}
