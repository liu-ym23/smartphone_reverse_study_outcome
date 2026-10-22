package com.bytedance.android.livesdk.interactivity.comment.record.event;

import com.alibaba.gaiax.model.GXAnimation;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
public final class HighlightRecordEvent {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f136107b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Type f136108a;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/record/event/HighlightRecordEvent$Type;", "", GXAnimation.STATE_START, "STOP", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Type extends Enum<Type> {
        public static final Type START = null;
        public static final Type STOP = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Type[] f136109a = null;

        static {
            Type r100 = new Type(GXAnimation.STATE_START, 0);
            START = r100;
            Type r101 = new Type("STOP", 1);
            STOP = r101;
            f136109a = new Type[]{r100, r101};
        }

        public static Type valueOf(String r100) {
            return (Type) r27.a.a(Type.class, r100);
        }

        public static Type[] values() {
            return (Type[]) f136109a.clone();
        }

        public Type(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    static {
    }

    public HighlightRecordEvent() {
    }

    public final Type getType() {
        return this.f136108a;
    }
}
