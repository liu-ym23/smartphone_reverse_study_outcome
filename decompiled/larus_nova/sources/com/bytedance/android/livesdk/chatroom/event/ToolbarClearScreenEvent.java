package com.bytedance.android.livesdk.chatroom.event;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes7.dex */
public final class ToolbarClearScreenEvent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Source f106203a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f106204b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f106205c;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/event/ToolbarClearScreenEvent$Source;", "", "Default", "SlideRoom", "PreviewEntrance", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Source extends Enum<Source> {
        public static final Source Default = null;
        public static final Source PreviewEntrance = null;
        public static final Source SlideRoom = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Source[] f106206a = null;

        static {
            Source r100 = new Source("Default", 0);
            Default = r100;
            Source r101 = new Source("SlideRoom", 1);
            SlideRoom = r101;
            Source r102 = new Source("PreviewEntrance", 2);
            PreviewEntrance = r102;
            f106206a = new Source[]{r100, r101, r102};
        }

        public static Source valueOf(String r100) {
            return (Source) a.a(Source.class, r100);
        }

        public static Source[] values() {
            return (Source[]) f106206a.clone();
        }

        public Source(String r100, int r101) {
            super(r100, r101);
        }
    }

    public ToolbarClearScreenEvent(boolean r100, boolean r101) {
        this.f106204b = r100;
        this.f106205c = r101;
        this.f106203a = Source.Default;
    }
}
