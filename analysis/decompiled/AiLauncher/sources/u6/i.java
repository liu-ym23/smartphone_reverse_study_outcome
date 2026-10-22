package u6;

import La.C;
import La.H;
import P6.DocumentPreviewResponse;
import P6.DownloadUrlResponse;
import Y8.t;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.common.utils.filestorage.FileStorageManager;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import v9.C5685n;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\bJ?\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00042\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\n2\u0014\u0010\u000e\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\u000f\u0010\u0010JW\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\u0012\u001a\u00020\u00112 \u0010\u0015\u001a\u001c\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0014\u0012\u0004\u0012\u00020\u000b0\u00132\u0014\u0010\u000e\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\u0016\u0010\u0017JY\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001b\u001a\u00020\u00192\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\n2\u0014\u0010\u000e\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b!\u0010\"R\u001c\u0010%\u001a\n $*\u0004\u0018\u00010#0#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006'"}, d2 = {"Lu6/i;", "", "<init>", "()V", "", "url", "", "n", "(Ljava/lang/String;)Ljava/lang/Long;", "fileId", "Lkotlin/Function1;", "LY8/t;", "onUrl", "", "onError", "e", "(Ljava/lang/String;Lp9/l;Lp9/l;)V", "", "allowRetry", "Lkotlin/Function2;", "Lkotlin/Function0;", "action", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;ZLp9/p;Lp9/l;)V", "dstType", "", "page", "expiresSeconds", "k", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ILp9/l;Lp9/l;)V", "fallbackTtlMs", "m", "(Ljava/lang/String;J)J", "FALLBACK_TTL_MS", "J", "Ljava/time/format/DateTimeFormatter;", "kotlin.jvm.PlatformType", "TOS_DATE", "Ljava/time/format/DateTimeFormatter;", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class i {
    private static final long FALLBACK_TTL_MS = 300000;
    public static final i INSTANCE = new i();
    private static final DateTimeFormatter TOS_DATE = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmmss'Z'");

    public static final t f(String str, InterfaceC5074l interfaceC5074l, DownloadUrlResponse resp) {
        p.i(resp, "resp");
        C5581d.INSTANCE.f(str, resp.getDownloadUrl(), INSTANCE.m(resp.getDownloadUrl(), 300000L));
        interfaceC5074l.invoke(resp.getDownloadUrl());
        return t.f7040a;
    }

    public static /* synthetic */ void h(i iVar, String str, boolean z10, p9.p pVar, InterfaceC5074l interfaceC5074l, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = true;
        }
        iVar.g(str, z10, pVar, interfaceC5074l);
    }

    public static final t i(boolean z10, final p9.p pVar, final String str, final InterfaceC5074l interfaceC5074l, String url) {
        p.i(url, "url");
        pVar.invoke(url, z10 ? new InterfaceC5063a() { // from class: u6.g
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return i.j(str, pVar, interfaceC5074l);
            }
        } : null);
        return t.f7040a;
    }

    public static final t j(String str, p9.p pVar, InterfaceC5074l interfaceC5074l) {
        C5581d.INSTANCE.e(C5578a.INSTANCE.a(str));
        INSTANCE.g(str, false, pVar, interfaceC5074l);
        return t.f7040a;
    }

    public static final t l(String str, int i10, InterfaceC5074l interfaceC5074l, DocumentPreviewResponse resp) {
        p.i(resp, "resp");
        C5581d.INSTANCE.f(str, resp.getPreviewUrl(), INSTANCE.m(resp.getPreviewUrl(), i10 * 1000));
        interfaceC5074l.invoke(resp.getPreviewUrl());
        return t.f7040a;
    }

    public final void e(String fileId, final InterfaceC5074l<? super String, t> onUrl, InterfaceC5074l<? super Throwable, t> onError) {
        p.i(fileId, "fileId");
        p.i(onUrl, "onUrl");
        p.i(onError, "onError");
        final String strA = C5578a.INSTANCE.a(fileId);
        String strD = C5581d.INSTANCE.d(strA);
        if (strD != null) {
            onUrl.invoke(strD);
        } else {
            FileStorageManager.j(FileStorageManager.INSTANCE, fileId, null, null, new InterfaceC5074l() { // from class: u6.h
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return i.f(strA, onUrl, (DownloadUrlResponse) obj);
                }
            }, onError, 6, null);
        }
    }

    public final void g(final String fileId, final boolean allowRetry, final p9.p<? super String, ? super InterfaceC5063a<t>, t> action, final InterfaceC5074l<? super Throwable, t> onError) {
        p.i(fileId, "fileId");
        p.i(action, "action");
        p.i(onError, "onError");
        e(fileId, new InterfaceC5074l() { // from class: u6.f
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return i.i(allowRetry, action, fileId, onError, (String) obj);
            }
        }, onError);
    }

    public final void k(String fileId, String dstType, Integer page, final int expiresSeconds, final InterfaceC5074l<? super String, t> onUrl, InterfaceC5074l<? super Throwable, t> onError) {
        p.i(fileId, "fileId");
        p.i(dstType, "dstType");
        p.i(onUrl, "onUrl");
        p.i(onError, "onError");
        final String strB = C5578a.INSTANCE.b(fileId, dstType, page);
        String strD = C5581d.INSTANCE.d(strB);
        if (strD != null) {
            onUrl.invoke(strD);
        } else {
            FileStorageManager.INSTANCE.k(fileId, dstType, Integer.valueOf(expiresSeconds), page, new InterfaceC5074l() { // from class: u6.e
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return i.l(strB, expiresSeconds, onUrl, (DocumentPreviewResponse) obj);
                }
            }, onError);
        }
    }

    public final long m(String url, long fallbackTtlMs) {
        Long lN = n(url);
        return lN != null ? C5685n.g(lN.longValue() - System.currentTimeMillis(), 0L) : fallbackTtlMs;
    }

    public final Long n(String url) {
        Object objB;
        p.i(url, "url");
        String strW1 = H.w1(H.n1(url, "X-Tos-Date=", ""), '&', null, 2, null);
        Long lY = C.y(H.w1(H.n1(url, "X-Tos-Expires=", ""), '&', null, 2, null));
        if (H.x0(strW1) || lY == null) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(LocalDateTime.parse(strW1, TOS_DATE).toInstant(ZoneOffset.UTC));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        Instant instant = (Instant) objB;
        if (instant == null) {
            return null;
        }
        return Long.valueOf(instant.toEpochMilli() + (lY.longValue() * 1000));
    }
}
