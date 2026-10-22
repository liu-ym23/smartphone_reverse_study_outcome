package com.obric.agent.intents.music.netease;

import com.bytedance.retrofit2.c.aa;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: compiled from: CloudMusicOpenApi.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface CloudMusicOpenApi {

    /* JADX INFO: compiled from: CloudMusicOpenApi.kt */
    public static final class a {
        public static /* synthetic */ Object a(CloudMusicOpenApi r2, Map r3, boolean r4, d.c.d r5, int r6, Object r7) {
            CloudMusicOpenApi r8 = (CloudMusicOpenApi) ZeusTransformUtils.wrapperContextForParams(r2, CloudMusicOpenApi.class, "com.obric.aiagent.plugin");
            Map<String, String> r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
            d.c.d<? super String> r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            if (r7 != null) goto L10;
            if ((r6 & 2) == 0) goto L8;
            r4 = false;
        L8:
            return r8.anonymousLogin(r9, r4, r10);
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: anonymousLogin");
        }

        public static /* synthetic */ Object b(CloudMusicOpenApi r2, Map r3, boolean r4, d.c.d r5, int r6, Object r7) {
            CloudMusicOpenApi r8 = (CloudMusicOpenApi) ZeusTransformUtils.wrapperContextForParams(r2, CloudMusicOpenApi.class, "com.obric.aiagent.plugin");
            Map<String, String> r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
            d.c.d<? super String> r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            if (r7 != null) goto L10;
            if ((r6 & 2) == 0) goto L8;
            r4 = false;
        L8:
            return r8.searchSong(r9, r4, r10);
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: searchSong");
        }

        public static /* synthetic */ Object c(CloudMusicOpenApi r2, Map r3, boolean r4, d.c.d r5, int r6, Object r7) {
            CloudMusicOpenApi r8 = (CloudMusicOpenApi) ZeusTransformUtils.wrapperContextForParams(r2, CloudMusicOpenApi.class, "com.obric.aiagent.plugin");
            Map<String, String> r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
            d.c.d<? super String> r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            if (r7 != null) goto L10;
            if ((r6 & 2) == 0) goto L8;
            r4 = false;
        L8:
            return r8.searchAlbum(r9, r4, r10);
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: searchAlbum");
        }

        public static /* synthetic */ Object d(CloudMusicOpenApi r2, Map r3, boolean r4, d.c.d r5, int r6, Object r7) {
            CloudMusicOpenApi r8 = (CloudMusicOpenApi) ZeusTransformUtils.wrapperContextForParams(r2, CloudMusicOpenApi.class, "com.obric.aiagent.plugin");
            Map<String, String> r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
            d.c.d<? super String> r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            if (r7 != null) goto L10;
            if ((r6 & 2) == 0) goto L8;
            r4 = false;
        L8:
            return r8.getAlbumSongs(r9, r4, r10);
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getAlbumSongs");
        }
    }

    @com.bytedance.retrofit2.c.h(a = "/openapi/music/basic/oauth2/login/anonymous")
    Object anonymousLogin(@aa Map<String, String> r1, @com.bytedance.retrofit2.c.a boolean r2, d.c.d<? super String> r3);

    @com.bytedance.retrofit2.c.h(a = "/openapi/music/basic/album/song/list/get/v3")
    Object getAlbumSongs(@aa Map<String, String> r1, @com.bytedance.retrofit2.c.a boolean r2, d.c.d<? super String> r3);

    @com.bytedance.retrofit2.c.h(a = "/openapi/music/basic/search/album/get/v2")
    Object searchAlbum(@aa Map<String, String> r1, @com.bytedance.retrofit2.c.a boolean r2, d.c.d<? super String> r3);

    @com.bytedance.retrofit2.c.h(a = "/openapi/music/basic/search/playlist/get/v1")
    Object searchPlaylist(@aa Map<String, String> r1, @com.bytedance.retrofit2.c.a boolean r2, d.c.d<? super String> r3);

    @com.bytedance.retrofit2.c.h(a = "/openapi/music/basic/search/song/get/v3")
    Object searchSong(@aa Map<String, String> r1, @com.bytedance.retrofit2.c.a boolean r2, d.c.d<? super String> r3);
}
