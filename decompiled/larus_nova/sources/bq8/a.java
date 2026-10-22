package bq8;

import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.block.MusicCreationContent;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;

/* JADX INFO: loaded from: classes26.dex */
@Serializable(with = b.class)
public final class a extends MusicCreationContent {
    public static final C0340a Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f20048a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f20049b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f20050c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f20051d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f20052e;

    /* JADX INFO: renamed from: bq8.a$a, reason: collision with other inner class name */
    public static final class C0340a {
        public C0340a() {
        }

        public final juc.d<a> serializer() {
            return b.f20053a;
        }
    }

    public a() {
        super(1);
        this.f20049b = "";
    }

    public final int getType() {
        return 0;
    }

    static {
        Companion = new C0340a();
    }

    public final d b() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L7
        ouc.a.C7114a r101 = ouc.a.f526798d;     // Catch: Throwable -> L7
        juc.d<d> r102 = d.Companion.serializer();     // Catch: Throwable -> L7
        String r103 = this.f20049b;     // Catch: Throwable -> L7
        if (r103 != null) goto L5;
        r103 = "";
    L5:
        Object r104 = Result.m9449constructorimpl((d) r101.c(r102, r103));     // Catch: Throwable -> L7
    L9:
        d r105 = new d();
        if (Result.m9455isFailureimpl(r104) == false) goto L13;
        r104 = r105;
    L13:
        return (d) r104;
    L7:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L9
    }

    public a(c r210) {
        Intrinsics.checkNotNullParameter(r210, "surrogate");
        this();
        String r100 = r210.f20055a;
        String r101 = "";
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        setVid(r100);
        String r102 = r210.f20056b;
        if (r102 != null) goto L8;
        r102 = "";
    L8:
        setVideoModel(r102);
        String r103 = r210.f20057c;
        if (r103 != null) goto L11;
        r103 = "";
    L11:
        setShareInfo(r103);
        String r104 = r210.f20058d;
        if (r104 != null) goto L14;
        r104 = "";
    L14:
        setCreator(r104);
        String r105 = r210.f20059e;
        if (r105 != null) goto L17;
        r105 = "";
    L17:
        setLyrics(r105);
        String r106 = r210.f20060f;
        if (r106 != null) goto L20;
        r106 = "";
    L20:
        setLyricsSeekContent(r106);
        String r107 = r210.f20061g;
        if (r107 != null) goto L23;
        r107 = "";
    L23:
        setTitle(r107);
        Boolean r108 = r210.f20062h;
        boolean r109 = false;
        if (r108 == null) goto L26;
        boolean r110 = r108.booleanValue();
    L27:
        setTitleEdited(r110);
        Image r111 = r210.f20063i;
        if (r111 != null) goto L30;
        r111 = new Image(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383, null);
    L30:
        setCover(r111);
        Boolean r112 = r210.f20064j;
        if (r112 == null) goto L33;
        boolean r113 = r112.booleanValue();
    L34:
        setCoverEdited(r113);
        String r114 = r210.f20065k;
        if (r114 != null) goto L37;
        r114 = "";
    L37:
        setCoverMainColor(r114);
        Boolean r115 = r210.f20066l;
        if (r115 == null) goto L40;
        boolean r116 = r115.booleanValue();
    L41:
        setMusicGenFailed(r116);
        String r117 = r210.f20067m;
        if (r117 != null) goto L44;
        r117 = "";
    L44:
        setMusicGenFailedMsg(r117);
        String r118 = r210.f20068n;
        if (r118 != null) goto L47;
        r118 = "";
    L47:
        setChunkUrl(r118);
        Integer r119 = r210.f20069o;
        if (r119 == null) goto L50;
        int r120 = r119.intValue();
    L51:
        setMusicGenType(r120);
        String r121 = r210.f20070p;
        if (r121 != null) goto L54;
        r121 = "";
    L54:
        setUseTemplateId(r121);
        String r122 = r210.f20071q;
        if (r122 != null) goto L57;
        r122 = "";
    L57:
        setUniqueTaskId(r122);
        Boolean r123 = r210.f20072r;
        if (r123 == null) goto L60;
        r109 = r123.booleanValue();
    L60:
        setBlock(r109);
        Long r124 = r210.f20073s;
        long r125 = 0;
        if (r124 == null) goto L63;
        long r126 = r124.longValue();
    L64:
        this.f20048a = r126;
        String r127 = r210.f20074t;
        if (r127 == null) goto L68;
        r101 = r127;
    L68:
        this.f20049b = r101;
        Long r128 = r210.f20075u;
        if (r128 == null) goto L71;
        r125 = r128.longValue();
    L71:
        this.f20050c = r125;
        this.f20051d = r210.f20076v;
        setContentType(1);
        return;
    L63:
        r126 = 0;
        goto L64
    L50:
        r120 = 0;
        goto L51
    L40:
        r116 = false;
        goto L41
    L33:
        r113 = false;
        goto L34
    L26:
        r110 = false;
        goto L27
    }
}
