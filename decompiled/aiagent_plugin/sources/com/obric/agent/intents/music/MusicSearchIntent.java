package com.obric.agent.intents.music;

import android.content.Context;
import android.os.Parcelable;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.agent.IAgentService;
import com.obric.aiagent.assistant.idl.IFlowMessageIDL;
import com.obric.aiagent.assistant.idl.ak;
import com.obric.aiagent.assistant.idl.bean.AppIntentCardData;
import com.obric.aiagent.assistant.idl.bean.AppIntentMessage;
import com.obric.aiagent.assistant.idl.bean.DataSource;
import com.obric.aiagent.assistant.idl.bean.OAppIntentBizContentType;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.plugin.R;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.intent.BaseNetEaseCloudMusicSearchIntent;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.common.intent.NetEaseCloudMusicSearchParams;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.Artist;
import com.obric.capabilitykit.entity.app.Cover;
import com.obric.capabilitykit.entity.app.MusicEntity;
import com.obric.capabilitykit.entity.app.Preview;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ax;
import d.a.p;
import d.h.b.aa;
import d.h.b.o;
import d.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlinx.coroutines.n;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: MusicSearchIntent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MusicSearchIntent extends BaseNetEaseCloudMusicSearchIntent {
    public static final a Companion = null;
    private static final int ENTITY_TYPE_ALBUM = 2;
    private static final int ENTITY_TYPE_RED_HEART = 103;
    private static final int ENTITY_TYPE_SONG = 1;
    private static final String EXT_LOCAL_MESSAGE_ID = "local_message_id";
    private static final int MAX_PLAY_LIST_SIZE = 30;

    /* JADX INFO: compiled from: MusicSearchIntent.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: MusicSearchIntent.kt */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<MusicEntity> f14703a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f14704b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (o.a(this.f14703a, r6.f14703a) == true) goto L12;
            return false;
        L12:
            if (this.f14704b == r6.f14704b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f14703a.hashCode() * 31) + Boolean.hashCode(this.f14704b);
        }

        public String toString() {
            return "ParseSongsResult(songs=" + this.f14703a + ", hasFilteredUnavailableSong=" + this.f14704b + ')';
        }

        public b(List<MusicEntity> r3, boolean r4) {
            List<MusicEntity> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            o.e(r5, "songs");
            this.f14703a = r5;
            this.f14704b = r4;
        }

        public /* synthetic */ b(List r2, boolean r3, int r4, d.h.b.h r5) {
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
            if ((r4 & 2) == 0) goto L5;
            r3 = false;
        L5:
            this(r6, r3);
        }

        public final List<MusicEntity> a() {
            return this.f14703a;
        }

        public final boolean b() {
            return this.f14704b;
        }
    }

    /* JADX INFO: compiled from: MusicSearchIntent.kt */
    private static abstract class c {

        /* JADX INFO: compiled from: MusicSearchIntent.kt */
        public static final class a extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f14705a = null;

            static {
                f14705a = new a();
            }

            public boolean equals(Object r3) {
                if (this != r3) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r3, a.class) == true) goto L9;
                return false;
            L9:
                a r2 = (a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.aiagent.plugin");
                return true;
            }

            public int hashCode() {
                return -1483132566;
            }

            public String toString() {
                return "Empty";
            }

            private a() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: MusicSearchIntent.kt */
        public static final class b extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final String f14706a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final int f14707b;

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
                return false;
            L8:
                b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
                if (o.a(this.f14706a, r6.f14706a) == true) goto L12;
                return false;
            L12:
                if (this.f14707b == r6.f14707b) goto L14;
                return false;
            L14:
                return true;
            }

            public int hashCode() {
                return (this.f14706a.hashCode() * 31) + Integer.hashCode(this.f14707b);
            }

            public String toString() {
                return "Failure(error=" + this.f14706a + ", code=" + this.f14707b + ')';
            }

            public /* synthetic */ b(String r1, int r2, int r3, d.h.b.h r4) {
                if ((r3 & 2) == 0) goto L5;
                r2 = 1;
            L5:
                this(r1, r2);
            }

            public final String a() {
                return this.f14706a;
            }

            public final int b() {
                return this.f14707b;
            }

            public b(String r2, int r3) {
                o.e(r2, WsConstants.KEY_CONNECTION_ERROR);
                super(null);
                this.f14706a = r2;
                this.f14707b = r3;
            }
        }

        /* JADX INFO: renamed from: com.obric.agent.intents.music.MusicSearchIntent$c$c, reason: collision with other inner class name */
        /* JADX INFO: compiled from: MusicSearchIntent.kt */
        public static final class C0293c extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0293c f14708a = null;

            static {
                f14708a = new C0293c();
            }

            public boolean equals(Object r3) {
                if (this != r3) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r3, C0293c.class) == true) goto L9;
                return false;
            L9:
                C0293c r2 = (C0293c) ZeusTransformUtils.preCheckCast(r3, C0293c.class, "com.obric.aiagent.plugin");
                return true;
            }

            public int hashCode() {
                return 851357843;
            }

            public String toString() {
                return "FilteredEmpty";
            }

            private C0293c() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: MusicSearchIntent.kt */
        public static final class d extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final List<MusicEntity> f14709a;

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
                return false;
            L8:
                d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.aiagent.plugin");
                if (o.a(this.f14709a, r6.f14709a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public int hashCode() {
                return this.f14709a.hashCode();
            }

            public String toString() {
                return "Success(songs=" + this.f14709a + ')';
            }

            public d(List<MusicEntity> r3) {
                List<MusicEntity> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
                o.e(r4, "songs");
                super(null);
                this.f14709a = r4;
            }

            public final List<MusicEntity> a() {
                return this.f14709a;
            }
        }

        public /* synthetic */ c(d.h.b.h r1) {
            this();
        }

        private c() {
        }
    }

    /* JADX INFO: compiled from: MusicSearchIntent.kt */
    public /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14710a = null;

        static {
            int[] r0 = new int[com.obric.agent.intents.music.netease.d.a.values().length];
            r0[com.obric.agent.intents.music.netease.d.a.f14764a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[com.obric.agent.intents.music.netease.d.a.f14765b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f14710a = r0;
        }
    }

    /* JADX INFO: compiled from: MusicSearchIntent.kt */
    @d.c.b.a.f(b = "MusicSearchIntent.kt", c = {74, 80, 83, 84, 91, 94, 95}, d = "doAction", e = "com.obric.agent.intents.music.MusicSearchIntent")
    static final class e extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f14711a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f14712b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f14713c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ MusicSearchIntent f14714d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f14715e;

        e(MusicSearchIntent r3, d.c.d<? super e> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14714d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f14713c = r3;
            this.f14715e |= Integer.MIN_VALUE;
            return this.f14714d.doAction(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: MusicSearchIntent.kt */
    @d.c.b.a.f(b = "MusicSearchIntent.kt", c = {206}, d = "handleSearchResult", e = "com.obric.agent.intents.music.MusicSearchIntent")
    static final class f extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f14716a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f14717b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f14718c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f14719d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f14720e;
        /* synthetic */ Object f;
        final /* synthetic */ MusicSearchIntent g;
        int h;

        f(MusicSearchIntent r3, d.c.d<? super f> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.g = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f = r3;
            this.h |= Integer.MIN_VALUE;
            return MusicSearchIntent.access$handleSearchResult(this.g, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: MusicSearchIntent.kt */
    @d.c.b.a.f(b = "MusicSearchIntent.kt", c = {404, 456}, d = "playSongList", e = "com.obric.agent.intents.music.MusicSearchIntent")
    static final class g extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f14721a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f14722b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f14723c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f14724d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f14725e;
        /* synthetic */ Object f;
        final /* synthetic */ MusicSearchIntent g;
        int h;

        g(MusicSearchIntent r3, d.c.d<? super g> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.g = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f = r3;
            this.h |= Integer.MIN_VALUE;
            return MusicSearchIntent.access$playSongList(this.g, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: MusicSearchIntent.kt */
    @d.c.b.a.f(b = "MusicSearchIntent.kt", c = {542, 553}, d = "searchAlbumAndGetSongs", e = "com.obric.agent.intents.music.MusicSearchIntent")
    static final class h extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f14726a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f14727b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f14728c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f14729d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ MusicSearchIntent f14730e;
        int f;

        h(MusicSearchIntent r3, d.c.d<? super h> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14730e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f14729d = r3;
            this.f |= Integer.MIN_VALUE;
            return MusicSearchIntent.access$searchAlbumAndGetSongs(this.f14730e, null, 0, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: MusicSearchIntent.kt */
    public static final class i implements com.obric.agent.intents.music.netease.f.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ n<String> f14731a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ MusicSearchIntent f14732b;

        i(n<? super String> r3, MusicSearchIntent r4) {
            this.f14731a = (n) ZeusTransformUtils.wrapperContextForParams(r3, n.class, "com.obric.aiagent.plugin");
            this.f14732b = r4;
        }

        @Override // com.obric.agent.intents.music.netease.f.a
        public void a(String r3) {
            o.e(r3, "responseJson");
            if (this.f14731a.a() == false) goto L6;
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this.f14731a, d.c.d.class, "com.obric.aiagent.plugin");
            d.n.a r0 = d.n.f38560a;
            r2.resumeWith(d.n.f(r3));
            return;
        }

        @Override // com.obric.agent.intents.music.netease.f.a
        public void b(String r5) {
            o.e(r5, WsConstants.KEY_CONNECTION_ERROR);
            ILogDepend.Companion.e(this.f14732b.getName(), "searchAlbums API failure: " + r5);
            if (this.f14731a.a() == false) goto L6;
            d.c.d r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this.f14731a, d.c.d.class, "com.obric.aiagent.plugin");
            d.n.a r6 = d.n.f38560a;
            r4.resumeWith(d.n.f(null));
            return;
        }
    }

    /* JADX INFO: compiled from: MusicSearchIntent.kt */
    public static final class j implements com.obric.agent.intents.music.netease.f.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ n<String> f14733a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ MusicSearchIntent f14734b;

        j(n<? super String> r3, MusicSearchIntent r4) {
            this.f14733a = (n) ZeusTransformUtils.wrapperContextForParams(r3, n.class, "com.obric.aiagent.plugin");
            this.f14734b = r4;
        }

        @Override // com.obric.agent.intents.music.netease.f.a
        public void a(String r3) {
            o.e(r3, "responseJson");
            if (this.f14733a.a() == false) goto L6;
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this.f14733a, d.c.d.class, "com.obric.aiagent.plugin");
            d.n.a r0 = d.n.f38560a;
            r2.resumeWith(d.n.f(r3));
            return;
        }

        @Override // com.obric.agent.intents.music.netease.f.a
        public void b(String r5) {
            o.e(r5, WsConstants.KEY_CONNECTION_ERROR);
            ILogDepend.Companion.e(this.f14734b.getName(), "getAlbumSongs API failure: " + r5);
            if (this.f14733a.a() == false) goto L6;
            d.c.d r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this.f14733a, d.c.d.class, "com.obric.aiagent.plugin");
            d.n.a r6 = d.n.f38560a;
            r4.resumeWith(d.n.f(null));
            return;
        }
    }

    /* JADX INFO: compiled from: MusicSearchIntent.kt */
    @d.c.b.a.f(b = "MusicSearchIntent.kt", c = {542}, d = "searchSongs", e = "com.obric.agent.intents.music.MusicSearchIntent")
    static final class k extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f14735a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f14736b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f14737c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f14738d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ MusicSearchIntent f14739e;
        int f;

        k(MusicSearchIntent r3, d.c.d<? super k> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14739e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f14738d = r3;
            this.f |= Integer.MIN_VALUE;
            return MusicSearchIntent.access$searchSongs(this.f14739e, null, 0, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: MusicSearchIntent.kt */
    public static final class l implements com.obric.agent.intents.music.netease.f.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ n<String> f14740a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ MusicSearchIntent f14741b;

        l(n<? super String> r3, MusicSearchIntent r4) {
            this.f14740a = (n) ZeusTransformUtils.wrapperContextForParams(r3, n.class, "com.obric.aiagent.plugin");
            this.f14741b = r4;
        }

        @Override // com.obric.agent.intents.music.netease.f.a
        public void a(String r3) {
            o.e(r3, "responseJson");
            if (this.f14740a.a() == false) goto L6;
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this.f14740a, d.c.d.class, "com.obric.aiagent.plugin");
            d.n.a r0 = d.n.f38560a;
            r2.resumeWith(d.n.f(r3));
            return;
        }

        @Override // com.obric.agent.intents.music.netease.f.a
        public void b(String r5) {
            o.e(r5, WsConstants.KEY_CONNECTION_ERROR);
            ILogDepend.Companion.e(this.f14741b.getName(), "searchSongs API failure: " + r5);
            if (this.f14740a.a() == false) goto L6;
            d.c.d r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this.f14740a, d.c.d.class, "com.obric.aiagent.plugin");
            d.n.a r6 = d.n.f38560a;
            r4.resumeWith(d.n.f(null));
            return;
        }
    }

    static {
        Companion = new a(null);
    }

    @Override // com.obric.capabilitykit.common.intent.BaseNetEaseCloudMusicSearchIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public boolean isBlock() {
        return true;
    }

    public MusicSearchIntent() {
    }

    public static final /* synthetic */ Object access$handleSearchResult(MusicSearchIntent r2, DispatchContext r3, c r4, d.c.d r5) {
        return r2.handleSearchResult(r3, r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object access$playSongList(MusicSearchIntent r2, DispatchContext r3, com.obric.agent.intents.music.netease.d.a r4, d.c.d r5) {
        return r2.playSongList(r3, r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object access$searchAlbumAndGetSongs(MusicSearchIntent r2, String r3, int r4, d.c.d r5) {
        return r2.searchAlbumAndGetSongs(r3, r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object access$searchSongs(MusicSearchIntent r2, String r3, int r4, d.c.d r5) {
        return r2.searchSongs(r3, r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.capabilitykit.common.intent.BaseNetEaseCloudMusicSearchIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public /* synthetic */ Object doAction(Parcelable r3, DispatchContext r4, d.c.d<? super IntentResult<MusicEntity[]>> r5) {
        Parcelable r6 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.aiagent.plugin");
        d.c.d<? super IntentResult<MusicEntity[]>> r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return doAction((NetEaseCloudMusicSearchParams) ZeusTransformUtils.preCheckCast(r6, NetEaseCloudMusicSearchParams.class, "com.obric.aiagent.plugin"), r4, r7);
    }

    @Override // com.obric.capabilitykit.common.intent.BaseNetEaseCloudMusicSearchIntent
    public Object doAction(NetEaseCloudMusicSearchParams r23, DispatchContext r24, d.c.d<? super IntentResult<MusicEntity[]>> r25) {
        MusicSearchIntent r0 = this;
        DispatchContext r1 = r24;
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r25, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, e.class) == false) goto L7;
        e r5 = (e) ZeusTransformUtils.preCheckCast(r3, e.class, "com.obric.aiagent.plugin");
        if ((r5.f14715e & Integer.MIN_VALUE) == 0) goto L7;
        r5.f14715e -= Integer.MIN_VALUE;
    L8:
        Object r4 = r5.f14713c;
        Object r6 = d.c.a.b.a();
        switch(r5.f14715e) {
            case 0: goto L19;
            case 1: goto L18;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            case 7: goto L12;
            default: goto L11;
        };
    L12:
        d.o.a(r4);
    L57:
        return r4;
    L13:
        DispatchContext r2 = (DispatchContext) ZeusTransformUtils.preCheckCast(r5.f14712b, DispatchContext.class, "com.obric.aiagent.plugin");
        MusicSearchIntent r7 = (MusicSearchIntent) ZeusTransformUtils.preCheckCast(r5.f14711a, MusicSearchIntent.class, "com.obric.aiagent.plugin");
        d.o.a(r4);
        r1 = r2;
        r0 = r7;
    L54:
        c r8 = (c) ZeusTransformUtils.preCheckCast(r4, c.class, "com.obric.aiagent.plugin");
        r5.f14711a = null;
        r5.f14712b = null;
        r5.f14715e = 7;
        r4 = r0.handleSearchResult(r1, r8, r5);
        if (r4 != r6) goto L57;
        return r6;
    L14:
        d.o.a(r4);
    L50:
        return r4;
    L15:
        d.o.a(r4);
    L74:
        return r4;
    L16:
        DispatchContext r9 = (DispatchContext) ZeusTransformUtils.preCheckCast(r5.f14712b, DispatchContext.class, "com.obric.aiagent.plugin");
        MusicSearchIntent r10 = (MusicSearchIntent) ZeusTransformUtils.preCheckCast(r5.f14711a, MusicSearchIntent.class, "com.obric.aiagent.plugin");
        d.o.a(r4);
        r1 = r9;
        r0 = r10;
    L71:
        c r11 = (c) ZeusTransformUtils.preCheckCast(r4, c.class, "com.obric.aiagent.plugin");
        r5.f14711a = null;
        r5.f14712b = null;
        r5.f14715e = 4;
        r4 = r0.handleSearchResult(r1, r11, r5);
        if (r4 != r6) goto L74;
        return r6;
    L17:
        d.o.a(r4);
    L67:
        return r4;
    L18:
        d.o.a(r4);
    L40:
        return r4;
    L19:
        d.o.a(r4);
        String r12 = r23.getQuery();
        Integer r13 = r23.getEntity_type();
        if (r13 == null) goto L22;
        int r14 = r13.intValue();
    L23:
        Integer r15 = r23.getCount();
        if (r15 == null) goto L26;
        int r16 = r15.intValue();
    L27:
        ILogDepend.Companion.i(getName(), "doAction query=" + r12 + ", entityType=" + r14 + ", count=" + r16);
        IntentResult<MusicEntity[]> r17 = r0.checkNeteaseInstallAndVersion((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r24.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        if (r17 == null) goto L30;
        return r17;
    L30:
        boolean r18 = false;
        if (r14 == 1) goto L58;
        if (r14 != 2) goto L34;
        CharSequence r19 = (CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin");
        if (r19 != null) goto L44;
    L45:
        r18 = true;
    L46:
        if (r18 == false) goto L51;
        com.obric.agent.intents.music.netease.d.a r20 = com.obric.agent.intents.music.netease.d.a.f14765b;
        r5.f14715e = 5;
        r4 = r0.playSongList(r1, r20, r5);
        if (r4 != r6) goto L50;
        return r6;
    L51:
        int r21 = d.l.n.a(r16, (d.l.f) ZeusTransformUtils.preCheckCast(new d.l.j(1, 15), d.l.f.class, "com.obric.aiagent.plugin"));
        r5.f14711a = r0;
        r5.f14712b = r1;
        r5.f14715e = 6;
        r4 = r0.searchAlbumAndGetSongs(r12, r21, r5);
        if (r4 != r6) goto L54;
        return r6;
    L44:
        if (d.o.o.d(r19) == false) goto L46;
    L34:
        if (r14 != 103) goto L36;
        com.obric.agent.intents.music.netease.d.a r22 = com.obric.agent.intents.music.netease.d.a.f14764a;
        r5.f14715e = 1;
        r4 = r0.playSongList(r1, r22, r5);
        if (r4 != r6) goto L40;
        return r6;
    L36:
        return new IntentResult(1, null, null, "entity_type must be 1, 2, 103", false, false, 1, null, null, null, 950, null);
    L58:
        CharSequence r26 = (CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin");
        if (r26 != null) goto L61;
    L62:
        r18 = true;
    L63:
        if (r18 == false) goto L68;
        com.obric.agent.intents.music.netease.d.a r27 = com.obric.agent.intents.music.netease.d.a.f14765b;
        r5.f14715e = 2;
        r4 = r0.playSongList(r1, r27, r5);
        if (r4 != r6) goto L67;
        return r6;
    L68:
        int r28 = d.l.n.a(r16, (d.l.f) ZeusTransformUtils.preCheckCast(new d.l.j(1, 15), d.l.f.class, "com.obric.aiagent.plugin"));
        r5.f14711a = r0;
        r5.f14712b = r1;
        r5.f14715e = 3;
        r4 = r0.searchSongs(r12, r28, r5);
        if (r4 != r6) goto L71;
        return r6;
    L61:
        if (d.o.o.d(r26) == false) goto L63;
    L26:
        r16 = 10;
        goto L27
    L22:
        r14 = 1;
        goto L23
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r5 = new e(r0, r3);
        goto L8
    }

    private final IntentResult<MusicEntity[]> checkNeteaseInstallAndVersion(Context r19) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r19, Context.class, "com.obric.aiagent.plugin");
        if (com.obric.agent.intents.music.netease.l.f14846a.a(r0) == true) goto L7;
        ILogDepend.Companion.w(getName(), "网易云音乐未安装");
        return new IntentResult(100, null, null, r0.getString(ZeusTransformUtils.mapRes(R.string.obric_netease_not_install, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_netease_not_install")), false, false, 1, null, null, null, 950, null);
    L7:
        if (com.obric.agent.intents.music.netease.l.f14846a.b(r0) == true) goto L10;
        ILogDepend.Companion.w(getName(), "网易云音乐版本过低");
        return new IntentResult(106, null, null, r0.getString(ZeusTransformUtils.mapRes(R.string.obric_netease_low_version, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_netease_low_version")), false, false, 1, null, null, null, 950, null);
    L10:
        return null;
    }

    private final Object handleSearchResult(DispatchContext r28, c r29, d.c.d<? super IntentResult<MusicEntity[]>> r30) {
        MusicSearchIntent r0 = this;
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r30, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, f.class) == false) goto L7;
        f r4 = (f) ZeusTransformUtils.preCheckCast(r2, f.class, "com.obric.aiagent.plugin");
        if ((r4.h & Integer.MIN_VALUE) == 0) goto L7;
        r4.h -= Integer.MIN_VALUE;
    L8:
        Object r3 = r4.f;
        Object r5 = d.c.a.b.a();
        int r6 = r4.h;
        if (r6 == 0) goto L14;
        if (r6 != 1) goto L13;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r4.f14720e, String.class, "com.obric.aiagent.plugin");
        Context r7 = (Context) ZeusTransformUtils.preCheckCast(r4.f14719d, Context.class, "com.obric.aiagent.plugin");
        List<MusicEntity> r8 = (List) ZeusTransformUtils.preCheckCast(r4.f14718c, List.class, "com.obric.aiagent.plugin");
        DispatchContext r9 = (DispatchContext) ZeusTransformUtils.preCheckCast(r4.f14717b, DispatchContext.class, "com.obric.aiagent.plugin");
        MusicSearchIntent r10 = (MusicSearchIntent) ZeusTransformUtils.preCheckCast(r4.f14716a, MusicSearchIntent.class, "com.obric.aiagent.plugin");
        d.o.a(r3);
        DispatchContext r13 = r9;
        String r11 = r1;
        r0 = r10;
    L41:
        int r15 = ((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).intValue();
        if (r15 == 0) goto L45;
        ILogDepend.Companion.w(r0.getName(), "autoPlay failed: code=" + r15);
        return new IntentResult(r15, null, null, r7.getString(ZeusTransformUtils.mapRes(R.string.obric_netease_api_error, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_netease_api_error")), false, false, 1, null, null, null, 950, null);
    L45:
        r0.sendMusicCard(r13, r8, r11);
        return new IntentResult(0, (MusicEntity[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.aiagent.plugin")).toArray(new MusicEntity[0]), MusicEntity[].class, "com.obric.aiagent.plugin"), null, r7.getString(ZeusTransformUtils.mapRes(R.string.obric_netease_search_result, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_netease_search_result"), new Object[]{d.c.b.a.b.a(r8.size())}), false, false, 4194312, null, null, r0.musicResultExt(r11), 436, null);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r3);
        if (ZeusTransformUtils.instanceOf(r29, c.b.class) == false) goto L18;
        ILogDepend.Companion.e(getName(), "search API failed: " + ((c.b) ZeusTransformUtils.preCheckCast(r29, c.b.class, "com.obric.aiagent.plugin")).a());
        return new IntentResult(((c.b) ZeusTransformUtils.preCheckCast(r29, c.b.class, "com.obric.aiagent.plugin")).b(), null, null, ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r28.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_netease_api_error, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_netease_api_error")), false, false, 1, null, null, null, 950, null);
    L18:
        if (ZeusTransformUtils.instanceOf(r29, c.a.class) == false) goto L21;
        return new IntentResult(10001, null, null, ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r28.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_netease_search_empty, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_netease_search_empty")), false, false, 1, null, null, null, 950, null);
    L21:
        if (ZeusTransformUtils.instanceOf(r29, c.C0293c.class) == false) goto L24;
        return new IntentResult(10003, null, null, ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r28.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_netease_search_empty, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_netease_search_empty")), false, false, 1, null, null, null, 950, null);
    L24:
        if (ZeusTransformUtils.instanceOf(r29, c.d.class) == false) goto L48;
        List<MusicEntity> r12 = ((c.d) ZeusTransformUtils.preCheckCast(r29, c.d.class, "com.obric.aiagent.plugin")).a();
        Context r14 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r28.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        com.obric.agent.n r16 = com.obric.agent.n.f15202a;
        Long r17 = r28.getQuestionId();
        if (r17 == null) goto L28;
        String r18 = r17.toString();
    L30:
        if (com.obric.agent.n.b(r16, r18, 0, 2, null) == false) goto L33;
        ILogDepend.Companion.i(getName(), "defer autoplay until decode card is received, questionId=" + r28.getQuestionId());
        return new IntentResult(0, (MusicEntity[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast(r12, Collection.class, "com.obric.aiagent.plugin")).toArray(new MusicEntity[0]), MusicEntity[].class, "com.obric.aiagent.plugin"), null, r14.getString(ZeusTransformUtils.mapRes(R.string.obric_netease_search_result, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_netease_search_result"), new Object[]{d.c.b.a.b.a(r12.size())}), false, false, 4194312, null, null, null, 948, null);
    L33:
        IFlowMessageIDL r19 = ak.a(aa.b(IFlowMessageIDL.class));
        if (r19 == null) goto L36;
        r11 = r19.generateLocalMessageId();
    L37:
        com.obric.agent.intents.music.netease.d r110 = com.obric.agent.intents.music.netease.d.f14762a;
        r4.f14716a = r0;
        r13 = r28;
        r4.f14717b = r13;
        r4.f14718c = r12;
        r4.f14719d = r14;
        r4.f14720e = r11;
        r4.h = 1;
        Object r20 = r110.a(r12, null, r11, r4);
        if (r20 != r5) goto L40;
        return r5;
    L40:
        r8 = r12;
        r7 = r14;
        r3 = r20;
        goto L41
    L36:
        r11 = null;
        goto L37
    L28:
        r18 = null;
        goto L30
    L48:
        throw new d.k();
    L7:
        r4 = new f(r0, r2);
        goto L8
    }

    private final Object searchSongs(String r12, int r13, d.c.d<? super c> r14) {
        d.c.d r15 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r14, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r15, k.class) == false) goto L7;
        k r0 = (k) ZeusTransformUtils.preCheckCast(r15, k.class, "com.obric.aiagent.plugin");
        if ((r0.f & Integer.MIN_VALUE) == 0) goto L7;
        r0.f -= Integer.MIN_VALUE;
    L8:
        Object r16 = r0.f14738d;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        int r11 = r0.f14737c;
        String r17 = (String) ZeusTransformUtils.preCheckCast(r0.f14736b, String.class, "com.obric.aiagent.plugin");
        MusicSearchIntent this = (MusicSearchIntent) ZeusTransformUtils.preCheckCast(r0.f14735a, MusicSearchIntent.class, "com.obric.aiagent.plugin");
        d.o.a(r16);
    L19:
        String r18 = (String) ZeusTransformUtils.preCheckCast(r16, String.class, "com.obric.aiagent.plugin");
        CharSequence r19 = (CharSequence) ZeusTransformUtils.preCheckCast(r18, CharSequence.class, "com.obric.aiagent.plugin");
        int r110 = 0;
        if (r19 != null) goto L22;
    L25:
        boolean r111 = true;
    L26:
        if (r111 == true) goto L28;
        b r112 = this.parseSongs(r18);
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r112.a(), Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L33;
        return (c) ZeusTransformUtils.preCheckCast(new c.d(r112.a()), c.class, "com.obric.aiagent.plugin");
    L33:
        if (r112.b() == false) goto L36;
        return (c) ZeusTransformUtils.preCheckCast(c.C0293c.f14708a, c.class, "com.obric.aiagent.plugin");
    L36:
        return (c) ZeusTransformUtils.preCheckCast(c.a.f14705a, c.class, "com.obric.aiagent.plugin");
    L28:
        return new c.b("API returned null/empty", r110, 2, null);
    L22:
        if (d.o.o.d(r19) == true) goto L25;
        r111 = false;
        goto L26
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r16);
        r0.f14735a = this;
        r0.f14736b = r12;
        r0.f14737c = r13;
        r0.f = 1;
        kotlinx.coroutines.o r4 = new kotlinx.coroutines.o(d.c.a.b.a((d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin")), 1);
        r4.e();
        com.obric.agent.intents.music.netease.f.f14802a.a(r12, r13, 0, true, (com.obric.agent.intents.music.netease.f.a) ZeusTransformUtils.preCheckCast(new l((n) ZeusTransformUtils.preCheckCast(r4, n.class, "com.obric.aiagent.plugin"), this), com.obric.agent.intents.music.netease.f.a.class, "com.obric.aiagent.plugin"));
        r16 = r4.h();
        if (r16 != d.c.a.b.a()) goto L17;
        d.c.b.a.h.c((d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin"));
    L17:
        if (r16 != r2) goto L19;
        return r2;
    L7:
        r0 = new k(this, r15);
        goto L8
    }

    private final Object searchAlbumAndGetSongs(String r19, int r20, d.c.d<? super c> r21) {
        MusicSearchIntent r0 = this;
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r21, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, h.class) == false) goto L7;
        h r5 = (h) ZeusTransformUtils.preCheckCast(r3, h.class, "com.obric.aiagent.plugin");
        if ((r5.f & Integer.MIN_VALUE) == 0) goto L7;
        r5.f -= Integer.MIN_VALUE;
    L8:
        Object r4 = r5.f14729d;
        Object r6 = d.c.a.b.a();
        int r7 = r5.f;
        d.h.b.h r8 = null;
        int r9 = 2;
        int r10 = 0;
        if (r7 == 0) goto L16;
        if (r7 == 1) goto L15;
        if (r7 != 2) goto L14;
        int r1 = r5.f14728c;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r5.f14727b, String.class, "com.obric.aiagent.plugin");
        r0 = (MusicSearchIntent) ZeusTransformUtils.preCheckCast(r5.f14726a, MusicSearchIntent.class, "com.obric.aiagent.plugin");
        d.o.a(r4);
    L41:
        String r11 = (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.aiagent.plugin");
        CharSequence r12 = (CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin");
        if (r12 != null) goto L44;
    L47:
        boolean r13 = true;
    L48:
        if (r13 == true) goto L50;
        b r14 = r0.parseSongs(r11);
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r14.a(), Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L55;
        return (c) ZeusTransformUtils.preCheckCast(new c.d(r14.a()), c.class, "com.obric.aiagent.plugin");
    L55:
        if (r14.b() == false) goto L58;
        return (c) ZeusTransformUtils.preCheckCast(c.C0293c.f14708a, c.class, "com.obric.aiagent.plugin");
    L58:
        return (c) ZeusTransformUtils.preCheckCast(c.a.f14705a, c.class, "com.obric.aiagent.plugin");
    L50:
        return new c.b("album songs API returned null/empty", r10, r9, r8);
    L44:
        if (d.o.o.d(r12) == true) goto L47;
        r13 = false;
        goto L48
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        int r15 = r5.f14728c;
        String r16 = (String) ZeusTransformUtils.preCheckCast(r5.f14727b, String.class, "com.obric.aiagent.plugin");
        MusicSearchIntent r17 = (MusicSearchIntent) ZeusTransformUtils.preCheckCast(r5.f14726a, MusicSearchIntent.class, "com.obric.aiagent.plugin");
        d.o.a(r4);
        int r18 = r15;
        r0 = r17;
    L22:
        String r22 = (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.aiagent.plugin");
        CharSequence r23 = (CharSequence) ZeusTransformUtils.preCheckCast(r22, CharSequence.class, "com.obric.aiagent.plugin");
        if (r23 != null) goto L25;
    L28:
        boolean r24 = true;
    L29:
        if (r24 == true) goto L31;
        String r110 = r0.parseFirstAlbumId(r22);
        if (r110 != null) goto L36;
        ILogDepend.Companion.w(r0.getName(), "searchAlbums returned empty records");
        return c.a.f14705a;
    L36:
        r5.f14726a = r0;
        r5.f14727b = r110;
        r5.f14728c = r18;
        r5.f = 2;
        kotlinx.coroutines.o r25 = new kotlinx.coroutines.o(d.c.a.b.a((d.c.d) ZeusTransformUtils.preCheckCast(r5, d.c.d.class, "com.obric.aiagent.plugin")), 1);
        r25.e();
        com.obric.agent.intents.music.netease.f.f14802a.b(r110, r18, 0, true, (com.obric.agent.intents.music.netease.f.a) ZeusTransformUtils.preCheckCast(new j((n) ZeusTransformUtils.preCheckCast(r25, n.class, "com.obric.aiagent.plugin"), r0), com.obric.agent.intents.music.netease.f.a.class, "com.obric.aiagent.plugin"));
        r4 = r25.h();
        if (r4 != d.c.a.b.a()) goto L39;
        d.c.b.a.h.c((d.c.d) ZeusTransformUtils.preCheckCast(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    L39:
        if (r4 != r6) goto L41;
        return r6;
    L31:
        return new c.b("album search API returned null/empty", r10, r9, r8);
    L25:
        if (d.o.o.d(r23) == true) goto L28;
        r24 = false;
        goto L29
    L16:
        d.o.a(r4);
        r5.f14726a = r0;
        r5.f14727b = r19;
        r5.f14728c = r20;
        r5.f = 1;
        kotlinx.coroutines.o r26 = new kotlinx.coroutines.o(d.c.a.b.a((d.c.d) ZeusTransformUtils.preCheckCast(r5, d.c.d.class, "com.obric.aiagent.plugin")), 1);
        r26.e();
        com.obric.agent.intents.music.netease.f.f14802a.a(r19, 1, 0, (com.obric.agent.intents.music.netease.f.a) ZeusTransformUtils.preCheckCast(new i((n) ZeusTransformUtils.preCheckCast(r26, n.class, "com.obric.aiagent.plugin"), r0), com.obric.agent.intents.music.netease.f.a.class, "com.obric.aiagent.plugin"));
        r4 = r26.h();
        if (r4 != d.c.a.b.a()) goto L19;
        d.c.b.a.h.c((d.c.d) ZeusTransformUtils.preCheckCast(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    L19:
        if (r4 != r6) goto L21;
        return r6;
    L21:
        r18 = r20;
    L7:
        r5 = new h(r0, r3);
        goto L8
    }

    private final String parseFirstAlbumId(String r5) {
        JSONObject r6 = new JSONObject(r5).optJSONObject("data");     // Catch: Exception -> L20
        if (r6 == null) goto L19;
        JSONArray r7 = r6.optJSONArray("records");     // Catch: Exception -> L20
        if (r7 == null) goto L19;
        if (r7.length() != 0) goto L11;
        return null;
    L11:
        JSONObject r8 = r7.optJSONObject(0);     // Catch: Exception -> L20
        if (r8 == null) goto L25;
        String r9 = r8.optString(DbHelper.COL_ID);     // Catch: Exception -> L20
        if (r9 == null) goto L26;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L28;
        return null;
    L28:
        return r9;
    L26:
        return null;
    L25:
        return null;
    L19:
        return null;
    L20:
        e = move-exception;
        ILogDepend.Companion.e(getName(), "parseFirstAlbumId error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return null;
    }

    private final b parseSongs(String r26) {
        String r0 = "optString(...)";
        JSONObject r6 = new JSONObject(r26).optJSONObject("data");     // Catch: Exception -> L64
        if (r6 == null) goto L63;
        JSONArray r7 = r6.optJSONArray("records");     // Catch: Exception -> L64
        if (r7 == null) goto L63;
        long r19 = System.currentTimeMillis();     // Catch: Exception -> L64
        ArrayList r15 = new ArrayList(r7.length());     // Catch: Exception -> L64
        int r14 = r7.length();     // Catch: Exception -> L64
        int r13 = 0;
        int r21 = 0;
    L9:
        boolean r8 = true;
        if (r13 >= r14) goto L56;
        JSONObject r9 = r7.optJSONObject(r13);     // Catch: Exception -> L64
        if (r9 != null) goto L14;
    L13:
        ArrayList r1 = r15;
    L55:
        r13 = r13 + 1;     // Catch: Exception -> L64
        r15 = r1;
        r0 = r0;
        r14 = r14;
        goto L9
    L14:
        String r10 = r9.optString("originalId");     // Catch: Exception -> L64
        o.a(r10);     // Catch: Exception -> L64
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L18;
        r10 = null;
    L18:
        if (r10 == null) goto L13;
        String r16 = r9.optString("name");     // Catch: Exception -> L64
        long r17 = r9.optLong("duration", 0);     // Catch: Exception -> L64
        int r11 = r9.optInt("songFee", -1);     // Catch: Exception -> L64
        boolean r12 = r9.optBoolean("visible", true);     // Catch: Exception -> L64
        if (r11 == 4) goto L54;
        if (r12 == false) goto L54;
        List r18 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L64
        JSONArray r110 = r9.optJSONArray("artists");     // Catch: Exception -> L64
        if (r110 == null) goto L33;
        int r111 = r110.length();     // Catch: Exception -> L64
        int r3 = 0;
    L27:
        if (r3 >= r111) goto L33;
        JSONObject r4 = r110.optJSONObject(r3);     // Catch: Exception -> L64
        if (r4 == null) goto L32;
        String r20 = r4.optString(DbHelper.COL_ID);     // Catch: Exception -> L64
        o.c(r20, r0);     // Catch: Exception -> L64
        String r5 = r4.optString("name");     // Catch: Exception -> L64
        o.c(r5, r0);     // Catch: Exception -> L64
        r18.add(new Artist(r20, r5));     // Catch: Exception -> L64
    L32:
        r3 = r3 + 1;     // Catch: Exception -> L64
    L33:
        JSONObject r22 = r9.optJSONObject("album");     // Catch: Exception -> L64
        if (r22 == null) goto L43;
        String r23 = r22.optString("name");     // Catch: Exception -> L64
        if (r23 == null) goto L43;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r23, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L41;
        r23 = null;
    L41:
        if (r23 == null) goto L43;
        Cover r24 = new Cover(r23);     // Catch: Exception -> L64
    L44:
        String r25 = r9.optString("coverImgUrl");     // Catch: Exception -> L64
        if (r25 != null) goto L47;
    L52:
        Preview r27 = null;
    L53:
        o.a(r16);     // Catch: Exception -> L64
        r1 = r15;
        r1.add(new MusicEntity(r10, r19, r19, r16, r18, r24, r27, r17));     // Catch: Exception -> L64
        goto L55
    L47:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r25, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L50;
        r25 = null;
    L50:
        if (r25 == null) goto L52;
        r27 = new Preview(r25);     // Catch: Exception -> L64
    L43:
        r24 = null;
    L54:
        r1 = r15;
        r21 = r21 + 1;     // Catch: Exception -> L64
        goto L55
    L56:
        ArrayList r2 = r15;
        List r28 = (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L64
        if (r2.isEmpty() == false) goto L60;
        if (r21 <= 0) goto L60;
    L75:
        return new b(r28, r8);
    L60:
        r8 = false;
    L63:
        return new b(p.b(), false, 2, null);
    L64:
        e = move-exception;
        ILogDepend.Companion.e(getName(), "parseSongs error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return new b(p.b(), false, 2, null);
    }

    private final Object playSongList(DispatchContext r33, com.obric.agent.intents.music.netease.d.a r34, d.c.d<? super IntentResult<MusicEntity[]>> r35) {
        MusicSearchIntent r0 = this;
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r35, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, g.class) == false) goto L7;
        g r5 = (g) ZeusTransformUtils.preCheckCast(r3, g.class, "com.obric.aiagent.plugin");
        if ((r5.h & Integer.MIN_VALUE) == 0) goto L7;
        r5.h -= Integer.MIN_VALUE;
    L8:
        Object r4 = r5.f;
        Object r6 = d.c.a.b.a();
        int r7 = r5.h;
        if (r7 == 0) goto L16;
        if (r7 == 1) goto L15;
        if (r7 != 2) goto L14;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r5.f14725e, String.class, "com.obric.aiagent.plugin");
        String r2 = (String) ZeusTransformUtils.preCheckCast(r5.f14724d, String.class, "com.obric.aiagent.plugin");
        c r8 = (c) ZeusTransformUtils.preCheckCast(r5.f14723c, c.class, "com.obric.aiagent.plugin");
        DispatchContext r9 = (DispatchContext) ZeusTransformUtils.preCheckCast(r5.f14722b, DispatchContext.class, "com.obric.aiagent.plugin");
        MusicSearchIntent r10 = (MusicSearchIntent) ZeusTransformUtils.preCheckCast(r5.f14721a, MusicSearchIntent.class, "com.obric.aiagent.plugin");
        d.o.a(r4);
        String r17 = r2;
    L86:
        int r11 = ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.aiagent.plugin")).intValue();
        if (r11 == 0) goto L90;
        ILogDepend.Companion.w(r10.getName(), "autoPlay failed: code=" + r11);
        return new IntentResult(r11, null, null, ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r9.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_netease_api_error, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_netease_api_error")), false, false, 1, null, null, null, 950, null);
    L90:
        r10.sendMusicCard(r9, ((c.d) ZeusTransformUtils.preCheckCast(r8, c.d.class, "com.obric.aiagent.plugin")).a(), r1);
        return new IntentResult(0, (MusicEntity[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast(((c.d) ZeusTransformUtils.preCheckCast(r8, c.d.class, "com.obric.aiagent.plugin")).a(), Collection.class, "com.obric.aiagent.plugin")).toArray(new MusicEntity[0]), MusicEntity[].class, "com.obric.aiagent.plugin"), null, r17, false, false, 4194312, null, null, r10.musicResultExt(r1), 436, null);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        com.obric.agent.intents.music.netease.d.a r12 = (com.obric.agent.intents.music.netease.d.a) ZeusTransformUtils.preCheckCast(r5.f14723c, com.obric.agent.intents.music.netease.d.a.class, "com.obric.aiagent.plugin");
        DispatchContext r13 = (DispatchContext) ZeusTransformUtils.preCheckCast(r5.f14722b, DispatchContext.class, "com.obric.aiagent.plugin");
        MusicSearchIntent r14 = (MusicSearchIntent) ZeusTransformUtils.preCheckCast(r5.f14721a, MusicSearchIntent.class, "com.obric.aiagent.plugin");
        d.o.a(r4);
        com.obric.agent.intents.music.netease.d.a r15 = r12;
        r0 = r14;
    L20:
        m r16 = (m) ZeusTransformUtils.preCheckCast(r4, m.class, "com.obric.aiagent.plugin");
        int r18 = ((Number) ZeusTransformUtils.preCheckCast(r16.c(), Number.class, "com.obric.aiagent.plugin")).intValue();
        com.obric.agent.intents.music.netease.a.a r19 = (com.obric.agent.intents.music.netease.a.a) ZeusTransformUtils.preCheckCast(r16.d(), com.obric.agent.intents.music.netease.a.a.class, "com.obric.aiagent.plugin");
        Set<String> r110 = null;
        if (r18 == 0) goto L23;
        c r20 = (c) ZeusTransformUtils.preCheckCast(new c.b("CMAPI prepare failed", r18), c.class, "com.obric.aiagent.plugin");
    L40:
        if (ZeusTransformUtils.instanceOf(r20, c.b.class) == false) goto L43;
        return new IntentResult(((c.b) ZeusTransformUtils.preCheckCast(r20, c.b.class, "com.obric.aiagent.plugin")).b(), null, null, ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r13.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_netease_api_error, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_netease_api_error")), false, false, 1, null, null, null, 950, null);
    L43:
        if (ZeusTransformUtils.instanceOf(r20, c.a.class) == false) goto L45;
    L93:
        int r21 = d.f14710a[r15.ordinal()];
        if (r21 != 1) goto L96;
        String r22 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r13.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_netease_redheart_empty, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_netease_redheart_empty"));
    L101:
        String r23 = r22;
        o.a(r23);
        return new IntentResult(10002, null, null, r23, false, false, 1, null, null, null, 950, null);
    L96:
        if (r21 != 2) goto L99;
        r22 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r13.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_netease_api_error, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_netease_api_error"));
        goto L101
    L99:
        throw new d.k();
    L45:
        if (ZeusTransformUtils.instanceOf(r20, c.C0293c.class) == true) goto L93;
        if (ZeusTransformUtils.instanceOf(r20, c.d.class) == false) goto L92;
        int r111 = d.f14710a[r15.ordinal()];
        if (r111 == 1) goto L55;
        if (r111 != 2) goto L54;
        String r112 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r13.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_netease_recommend, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_netease_recommend"));
    L56:
        o.a(r112);
        com.obric.agent.n r113 = com.obric.agent.n.f15202a;
        Long r114 = r13.getQuestionId();
        if (r114 == null) goto L59;
        String r115 = r114.toString();
    L61:
        if (com.obric.agent.n.b(r113, r115, 0, 2, null) == false) goto L64;
        ILogDepend.Companion.i(r0.getName(), "defer playlist autoplay until decode card is received, questionId=" + r13.getQuestionId());
        return new IntentResult(0, (MusicEntity[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast(((c.d) ZeusTransformUtils.preCheckCast(r20, c.d.class, "com.obric.aiagent.plugin")).a(), Collection.class, "com.obric.aiagent.plugin")).toArray(new MusicEntity[0]), MusicEntity[].class, "com.obric.aiagent.plugin"), null, r112, false, false, 4194312, null, null, null, 948, null);
    L64:
        IFlowMessageIDL r116 = ak.a(aa.b(IFlowMessageIDL.class));
        if (r116 == null) goto L67;
        String r117 = r116.generateLocalMessageId();
    L68:
        com.obric.agent.intents.music.netease.d r118 = com.obric.agent.intents.music.netease.d.f14762a;
        if (r19 == null) goto L80;
        List<com.obric.agent.intents.music.netease.a.b> r24 = r19.b();
        if (r24 == null) goto L80;
        Iterable r25 = (Iterable) ZeusTransformUtils.preCheckCast(r24, Iterable.class, "com.obric.aiagent.plugin");
        Collection r26 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r27 = r25.iterator();
    L74:
        if (r27.hasNext() == false) goto L79;
        String r119 = String.valueOf(((com.obric.agent.intents.music.netease.a.b) ZeusTransformUtils.preCheckCast(r27.next(), com.obric.agent.intents.music.netease.a.b.class, "com.obric.aiagent.plugin")).a());
        if (r119 == null) goto L74;
        r26.add(r119);
        goto L74
    L79:
        r110 = p.q((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r26, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"));
    L80:
        if (r110 != null) goto L82;
        r110 = ax.b();
    L82:
        r5.f14721a = r0;
        r5.f14722b = r13;
        r5.f14723c = r20;
        r5.f14724d = r112;
        r5.f14725e = r117;
        r5.h = 2;
        r4 = r118.a(r15, r110, r117, r5);
        if (r4 != r6) goto L85;
        return r6;
    L85:
        r10 = r0;
        r8 = r20;
        r17 = r112;
        r1 = r117;
        r9 = r13;
        goto L86
    L67:
        r117 = null;
        goto L68
    L59:
        r115 = null;
        goto L61
    L54:
        throw new d.k();
    L55:
        r112 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r13.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_netease_redheart, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_netease_redheart"));
        goto L56
    L92:
        throw new d.k();
    L23:
        if (r19 == null) goto L38;
        Collection r28 = (Collection) ZeusTransformUtils.preCheckCast(r19.b(), Collection.class, "com.obric.aiagent.plugin");
        if (r28 != null) goto L27;
    L30:
        boolean r29 = true;
    L31:
        if (r29 == true) goto L38;
        List<com.obric.agent.intents.music.netease.a.b> r30 = r19.b();
        if (r30 == null) goto L36;
        List<com.obric.agent.intents.music.netease.a.b> r31 = p.c((Iterable) ZeusTransformUtils.preCheckCast(r30, Iterable.class, "com.obric.aiagent.plugin"), 30);
    L37:
        r19.a(r31);
        r20 = (c) ZeusTransformUtils.preCheckCast(new c.d(r0.convertPlayListToMusicEntities(r19)), c.class, "com.obric.aiagent.plugin");
        goto L40
    L36:
        r31 = null;
        goto L37
    L27:
        if (r28.isEmpty() == true) goto L30;
        r29 = false;
    L38:
        r20 = (c) ZeusTransformUtils.preCheckCast(c.a.f14705a, c.class, "com.obric.aiagent.plugin");
        goto L40
    L16:
        d.o.a(r4);
        com.obric.agent.intents.music.netease.d r32 = com.obric.agent.intents.music.netease.d.f14762a;
        r5.f14721a = r0;
        r5.f14722b = r33;
        r5.f14723c = r34;
        r5.h = 1;
        Object r36 = r32.a(r34, r5);
        if (r36 != r6) goto L19;
        return r6;
    L19:
        r15 = r34;
        r13 = r33;
        r4 = r36;
    L7:
        r5 = new g(r0, r3);
        goto L8
    }

    private final List<MusicEntity> convertPlayListToMusicEntities(com.obric.agent.intents.music.netease.a.a r19) {
        long r12 = System.currentTimeMillis();
        List<com.obric.agent.intents.music.netease.a.b> r0 = r19.b();
        if (r0 == null) goto L40;
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin");
        Collection r15 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r16 = r1.iterator();
    L6:
        if (r16.hasNext() == false) goto L46;
        com.obric.agent.intents.music.netease.a.b r2 = (com.obric.agent.intents.music.netease.a.b) ZeusTransformUtils.preCheckCast(r16.next(), com.obric.agent.intents.music.netease.a.b.class, "com.obric.aiagent.plugin");
        String r3 = String.valueOf(r2.a());
        MusicEntity r4 = null;
        if ((!o.a(r3, "0")) == true) goto L11;
        r3 = null;
    L11:
        if (r3 == null) goto L36;
        String r5 = r2.b();
        if (r5 != null) goto L16;
        String r6 = "";
    L17:
        String r7 = r2.c();
        if (r7 != null) goto L20;
    L25:
        List r8 = null;
    L26:
        String r9 = r2.d();
        if (r9 != null) goto L29;
    L34:
        Preview r10 = null;
    L35:
        r4 = new MusicEntity(r3, r12, r12, r6, r8, null, r10, 0);
        goto L36
    L29:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L32;
        r9 = null;
    L32:
        if (r9 == null) goto L34;
        r10 = new Preview(r9);
        goto L35
    L20:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L23;
        r7 = null;
    L23:
        if (r7 == null) goto L25;
        r8 = p.a(new Artist("", r7));
        goto L26
    L16:
        r6 = r5;
    L36:
        if (r4 == null) goto L6;
        r15.add(r4);
        goto L6
    L46:
        return (List) ZeusTransformUtils.preCheckCast(r15, List.class, "com.obric.aiagent.plugin");
    L40:
        return p.b();
    }

    private final void sendMusicCard(DispatchContext r21, List<MusicEntity> r22, String r23) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r22, List.class, "com.obric.aiagent.plugin");
        Long r2 = r21.getQuestionId();
        if (r2 == null) goto L16;
        String r6 = r2.toString();
        if (r6 == null) goto L18;
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r1, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r4 = r1.iterator();
    L9:
        if (r4.hasNext() == false) goto L11;
        MusicEntity r5 = (MusicEntity) ZeusTransformUtils.preCheckCast(r4.next(), MusicEntity.class, "com.obric.aiagent.plugin");
        r3.add(AppIntentCardData.Companion.a((AppEntity) ZeusTransformUtils.preCheckCast(r5, AppEntity.class, "com.obric.aiagent.plugin")));
        goto L9
    L11:
        List r7 = (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin");
        String r8 = EntityExtKt.a().toJson(new AppIntentMessage(new DataSource("music", "netease_music", null, 4, null), true, false, null, null, false, false, null, (List) ZeusTransformUtils.preCheckCast(new ArrayList((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.aiagent.plugin")), List.class, "com.obric.aiagent.plugin"), null, 760, null));
        IAgentService r9 = (IAgentService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAgentService.class), IAgentService.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L17;
        o.a(r8);
        IAgentService.a.a(r9, r8, OAppIntentBizContentType.MUSIC_CARD, r6, 0, r23, 8, null);
        return;
    L17:
        return;
    L18:
        return;
    }

    private final ConcurrentHashMap<String, String> musicResultExt(String r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L8;
        r3 = null;
    L8:
        if (r3 == null) goto L13;
        ConcurrentHashMap<String, String> r2 = new ConcurrentHashMap();
        r2.put(EXT_LOCAL_MESSAGE_ID, r3);
        return r2;
    L13:
        return null;
    }
}
