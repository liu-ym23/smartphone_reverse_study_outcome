package com.bytedance.android.ec.model.response.anchorv3;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\t\n\u0002\b\u0012\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/SourceType;", "", "", "type", "J", "getType", "()J", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "TAOBAO", "GAME", "EASY_GO", "EASY_GO_SELECTED", "TAOBAO_PHONE", "XIAO_DIAN", "TAOBAO_COMMAND", "JINGDONG", "KAOLA", "UNKNOWN", "LIVEROOM", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final enum SourceType extends Enum<SourceType> {
    public static final a Companion = null;
    public static final SourceType EASY_GO = null;
    public static final SourceType EASY_GO_SELECTED = null;
    public static final int ELASTIC_TYPE_UPDATE = 2;
    public static final SourceType GAME = null;
    public static final SourceType JINGDONG = null;
    public static final SourceType KAOLA = null;
    public static final SourceType LIVEROOM = null;
    public static final int NEW = 2;
    public static final int NORMAL = 1;
    public static final int RECOMMEND = 3;
    public static final SourceType TAOBAO = null;
    public static final SourceType TAOBAO_COMMAND = null;
    public static final SourceType TAOBAO_PHONE = null;
    public static final SourceType UNKNOWN = null;
    public static final SourceType XIAO_DIAN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SourceType[] f47943a = null;
    private final long type;

    public static final class a {
        public a() {
        }

        public static boolean a(Long r100) {
            if (r100 != null) goto L5;
            return false;
        L5:
            SourceType[] r101 = SourceType.values();
            int r102 = r101.length;
            int r103 = 0;
        L6:
            if (r103 >= r102) goto L12;
            if (r101[r103].getType() == r100.longValue()) goto L9;
            r103 = r103 + 1;
            goto L6
        L9:
            return true;
        L12:
            return false;
        }

        public static boolean b(long r100) {
            if (r100 != SourceType.LIVEROOM.getType()) goto L5;
            return true;
        L5:
            return false;
        }

        @JvmStatic
        public static boolean c(long r100) {
            if (r100 != SourceType.GAME.getType()) goto L5;
        L12:
            return true;
        L5:
            if (r100 == SourceType.EASY_GO.getType()) goto L12;
            if (r100 == SourceType.EASY_GO_SELECTED.getType()) goto L12;
            if (r100 == SourceType.XIAO_DIAN.getType()) goto L12;
            return false;
        }

        @JvmStatic
        public static boolean d(long r100) {
            if (r100 != SourceType.TAOBAO.getType()) goto L5;
        L10:
            return true;
        L5:
            if (r100 == SourceType.TAOBAO_PHONE.getType()) goto L10;
            if (r100 == SourceType.TAOBAO_COMMAND.getType()) goto L10;
            return false;
        }

        public static boolean e(long r100) {
            if (r100 != SourceType.EASY_GO_SELECTED.getType()) goto L5;
        L7:
            return false;
        L5:
            if (r100 == SourceType.XIAO_DIAN.getType()) goto L7;
            return true;
        }
    }

    @JvmStatic
    public static final boolean isSelfGood(long r100) {
        Companion.getClass();
        return a.c(r100);
    }

    @JvmStatic
    public static final boolean isTaobaoGood(long r100) {
        Companion.getClass();
        return a.d(r100);
    }

    public static SourceType valueOf(String r100) {
        return (SourceType) r27.a.a(SourceType.class, r100);
    }

    public static SourceType[] values() {
        return (SourceType[]) f47943a.clone();
    }

    static {
        SourceType r100 = new SourceType("TAOBAO", 0, 1);
        TAOBAO = r100;
        SourceType r101 = new SourceType("GAME", 1, 2);
        GAME = r101;
        SourceType r102 = new SourceType("EASY_GO", 2, 3);
        EASY_GO = r102;
        SourceType r103 = new SourceType("EASY_GO_SELECTED", 3, 4);
        EASY_GO_SELECTED = r103;
        SourceType r104 = new SourceType("TAOBAO_PHONE", 4, 5);
        TAOBAO_PHONE = r104;
        SourceType r105 = new SourceType("XIAO_DIAN", 5, 6);
        XIAO_DIAN = r105;
        SourceType r106 = new SourceType("TAOBAO_COMMAND", 6, 7);
        TAOBAO_COMMAND = r106;
        SourceType r107 = new SourceType("JINGDONG", 7, 8);
        JINGDONG = r107;
        SourceType r108 = new SourceType("KAOLA", 8, 9);
        KAOLA = r108;
        SourceType r109 = new SourceType("UNKNOWN", 9, -1);
        UNKNOWN = r109;
        SourceType r110 = new SourceType("LIVEROOM", 10, 10);
        LIVEROOM = r110;
        f47943a = new SourceType[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110};
        Companion = new a();
    }

    public final long getType() {
        return this.type;
    }

    @JvmStatic
    public static final boolean isJDGood(long r100) {
        Companion.getClass();
        if (r100 != JINGDONG.getType()) goto L5;
        return true;
    L5:
        return false;
    }

    @JvmStatic
    public static final boolean isKaolaGood(long r100) {
        Companion.getClass();
        if (r100 != KAOLA.getType()) goto L5;
        return true;
    L5:
        return false;
    }

    public SourceType(String r100, int r101, long r102) {
        super(r100, r101);
        this.type = r102;
    }
}
