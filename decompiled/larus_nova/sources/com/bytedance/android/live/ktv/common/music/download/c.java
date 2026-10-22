package com.bytedance.android.live.ktv.common.music.download;

import com.bytedance.android.live.ktv.common.util.KtvSubElement;

/* JADX INFO: loaded from: classes45.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f70062a;

    public static final class a extends c {
        public a() {
            super("accompaniment_track");
        }
    }

    public static final class b extends c {
        public b() {
            super("full_track");
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.ktv.common.music.download.c$c, reason: collision with other inner class name */
    public static final class C1140c extends c {
        public C1140c() {
            super(KtvSubElement.LYRIC);
        }
    }

    public static final class d extends c {
        public d() {
            super(KtvSubElement.MIDI);
        }
    }

    public static final class e extends c {
        public e() {
            super(KtvSubElement.MV);
        }
    }

    public static final class f extends c {
        public f() {
            super("");
        }
    }

    public static final class g extends c {
        public g() {
            super("param_res");
        }
    }

    public c(String r100) {
        this.f70062a = r100;
    }
}
