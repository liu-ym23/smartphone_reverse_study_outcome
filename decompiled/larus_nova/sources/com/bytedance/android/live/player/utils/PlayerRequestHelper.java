package com.bytedance.android.live.player.utils;

import androidx.core.app.NotificationCompat;
import com.bytedance.android.livesdkapi.model.PlayerNameValuePair;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerApi;
import com.bytedance.android.livesdkapi.roomplayer.PlayerCall;
import com.bytedance.android.livesdkapi.roomplayer.PlayerHttpResponse;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedInput;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class PlayerRequestHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f85845a = null;

    public static final class a implements PlayerCall<PlayerHttpResponse> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Call<TypedInput> f85846a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f85847b;

        @Override // com.bytedance.android.livesdkapi.roomplayer.PlayerCall
        public final PlayerHttpResponse execute() {
            SsResponse<TypedInput> r100 = this.f85846a.execute();     // Catch: Exception -> L32
            TypedInput r101 = r100.body();     // Catch: Exception -> L32
            if (r101 != null) goto L6;
            byte[] r102 = null;
            InputStream r103 = null;
        L21:
            if (r100.raw() == null) goto L23;
            String r104 = r100.raw().getReason();     // Catch: Exception -> L32
            String r105 = r100.raw().getUrl();     // Catch: Exception -> L32
        L24:
            List<Header> r106 = r100.headers();     // Catch: Exception -> L32
            ArrayList r107 = new ArrayList();     // Catch: Exception -> L32
            Iterator<Header> r108 = r106.iterator();     // Catch: Exception -> L32
        L26:
            if (r108.hasNext() == false) goto L28;
            Header r109 = r108.next();     // Catch: Exception -> L32
            r107.add(new PlayerNameValuePair(r109.getName(), r109.getValue()));     // Catch: Exception -> L32
            goto L26
        L28:
            PlayerHttpResponse r110 = new PlayerHttpResponse().setUrl(r105).setStatusCode(r100.code()).setReason(r104).setHeaders(r107).setBody(r102).setStream(r103);     // Catch: Exception -> L32
            if (r101 == null) goto L39;
            r110.setMimeType(r101.mimeType());     // Catch: Exception -> L32
        L39:
            return r110;
        L23:
            r105 = "";
            r104 = "no reason";
            goto L24
        L6:
            if (this.f85847b == false) goto L9;
            r103 = r101.in();     // Catch: Exception -> L32
            r102 = null;
            goto L21
        L9:
            if ((r101 instanceof TypedByteArray) == false) goto L11;
            r102 = ((TypedByteArray) r101).getBytes();     // Catch: Exception -> L32
        L18:
            r103 = null;
            goto L21
        L11:
            InputStream r111 = r101.in();     // Catch: Exception -> L32
            ByteArrayOutputStream r112 = new ByteArrayOutputStream();     // Catch: Exception -> L32
            if (r111 == null) goto L17;
            byte[] r113 = new byte[4096];     // Catch: Exception -> L32
        L14:
            int r114 = r111.read(r113);     // Catch: Exception -> L32
            if (r114 == (-1)) goto L17;
            r112.write(r113, 0, r114);     // Catch: Exception -> L32
        L17:
            r102 = r112.toByteArray();     // Catch: Exception -> L32
        L32:
            e = move-exception;
            b.b(e.toString());
            return null;
        }

        public a(Call r100) {
            Intrinsics.checkNotNullParameter(r100, NotificationCompat.CATEGORY_CALL);
            this.f85846a = r100;
            this.f85847b = false;
        }
    }

    static {
        f85845a = LazyKt.lazy(PlayerRequestHelper$playerApi$2.INSTANCE);
    }

    @JvmStatic
    public static final a a(String r100, Map r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "map");
        StringBuilder r102 = new StringBuilder("playerApi@");
        Lazy r103 = f85845a;
        r102.append((ILivePlayerApi) r103.getValue());
        r102.append(" execute ");
        r102.append(r100);
        b.b(r102.toString());
        ILivePlayerApi r104 = (ILivePlayerApi) r103.getValue();
        if (r104 == null) goto L9;
        Call<TypedInput> r105 = r104.get(r100, r101);
        if (r105 != null) goto L8;
        return null;
    L8:
        return new a(r105);
    L9:
        return null;
    }
}
