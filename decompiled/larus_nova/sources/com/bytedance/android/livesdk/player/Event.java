package com.bytedance.android.livesdk.player;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\n\u0005\u0006\u0007\b\t\n\u000b\f\r\u000eB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u0082\u0001\n\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/player/Event;", "", "()V", "getName", "", "Background", "ChangeRenderView", "Foreground", "Mute", "Pause", "Prepare", "Release", "Start", "Stop", "UnMute", "Lcom/bytedance/android/livesdk/player/Event$Background;", "Lcom/bytedance/android/livesdk/player/Event$ChangeRenderView;", "Lcom/bytedance/android/livesdk/player/Event$Foreground;", "Lcom/bytedance/android/livesdk/player/Event$Mute;", "Lcom/bytedance/android/livesdk/player/Event$Pause;", "Lcom/bytedance/android/livesdk/player/Event$Prepare;", "Lcom/bytedance/android/livesdk/player/Event$Release;", "Lcom/bytedance/android/livesdk/player/Event$Start;", "Lcom/bytedance/android/livesdk/player/Event$Stop;", "Lcom/bytedance/android/livesdk/player/Event$UnMute;", "live-player-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class Event {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/player/Event$Background;", "Lcom/bytedance/android/livesdk/player/Event;", "()V", "getName", "", "live-player-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Background extends Event {
        public static final Background INSTANCE = null;

        private Background() {
            super(null);
        }

        @Override // com.bytedance.android.livesdk.player.Event
        public String getName() {
            return "Background";
        }

        static {
            INSTANCE = new Background();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/player/Event$ChangeRenderView;", "Lcom/bytedance/android/livesdk/player/Event;", "()V", "getName", "", "live-player-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ChangeRenderView extends Event {
        public static final ChangeRenderView INSTANCE = null;

        private ChangeRenderView() {
            super(null);
        }

        @Override // com.bytedance.android.livesdk.player.Event
        public String getName() {
            return "ChangeRenderView";
        }

        static {
            INSTANCE = new ChangeRenderView();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/player/Event$Foreground;", "Lcom/bytedance/android/livesdk/player/Event;", "()V", "getName", "", "live-player-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Foreground extends Event {
        public static final Foreground INSTANCE = null;

        private Foreground() {
            super(null);
        }

        @Override // com.bytedance.android.livesdk.player.Event
        public String getName() {
            return "Foreground";
        }

        static {
            INSTANCE = new Foreground();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/player/Event$Mute;", "Lcom/bytedance/android/livesdk/player/Event;", "()V", "getName", "", "live-player-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Mute extends Event {
        public static final Mute INSTANCE = null;

        private Mute() {
            super(null);
        }

        @Override // com.bytedance.android.livesdk.player.Event
        public String getName() {
            return "Mute";
        }

        static {
            INSTANCE = new Mute();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/player/Event$Pause;", "Lcom/bytedance/android/livesdk/player/Event;", "()V", "getName", "", "live-player-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Pause extends Event {
        public static final Pause INSTANCE = null;

        private Pause() {
            super(null);
        }

        @Override // com.bytedance.android.livesdk.player.Event
        public String getName() {
            return "Pause";
        }

        static {
            INSTANCE = new Pause();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0007\u0003\u0004\u0005\u0006\u0007\b\tB\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0082\u0001\u0007\n\u000b\f\r\u000e\u000f\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/player/Event$Prepare;", "Lcom/bytedance/android/livesdk/player/Event;", "()V", "FirstFrame", "PlayerPrepared", "PreCreateSurface", "PrePrepare", "RenderViewBound", "Reset", "SurfaceReady", "Lcom/bytedance/android/livesdk/player/Event$Prepare$FirstFrame;", "Lcom/bytedance/android/livesdk/player/Event$Prepare$PlayerPrepared;", "Lcom/bytedance/android/livesdk/player/Event$Prepare$PreCreateSurface;", "Lcom/bytedance/android/livesdk/player/Event$Prepare$PrePrepare;", "Lcom/bytedance/android/livesdk/player/Event$Prepare$RenderViewBound;", "Lcom/bytedance/android/livesdk/player/Event$Prepare$Reset;", "Lcom/bytedance/android/livesdk/player/Event$Prepare$SurfaceReady;", "live-player-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static abstract class Prepare extends Event {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/player/Event$Prepare$FirstFrame;", "Lcom/bytedance/android/livesdk/player/Event$Prepare;", "()V", "getName", "", "live-player-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class FirstFrame extends Prepare {
            public static final FirstFrame INSTANCE = null;

            private FirstFrame() {
                super(null);
            }

            @Override // com.bytedance.android.livesdk.player.Event
            public String getName() {
                return "Prepare.FirstFrame";
            }

            static {
                INSTANCE = new FirstFrame();
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/player/Event$Prepare$PlayerPrepared;", "Lcom/bytedance/android/livesdk/player/Event$Prepare;", "()V", "getName", "", "live-player-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class PlayerPrepared extends Prepare {
            public static final PlayerPrepared INSTANCE = null;

            private PlayerPrepared() {
                super(null);
            }

            @Override // com.bytedance.android.livesdk.player.Event
            public String getName() {
                return "Prepare.PlayerPrepared";
            }

            static {
                INSTANCE = new PlayerPrepared();
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/player/Event$Prepare$PreCreateSurface;", "Lcom/bytedance/android/livesdk/player/Event$Prepare;", "activity", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getActivity", "()Landroid/content/Context;", "getName", "", "live-player-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class PreCreateSurface extends Prepare {
            private final Context activity;

            @Override // com.bytedance.android.livesdk.player.Event
            public String getName() {
                return "Prepare.PreCreateSurface";
            }

            public final Context getActivity() {
                return this.activity;
            }

            public PreCreateSurface(Context r100) {
                Intrinsics.checkNotNullParameter(r100, "activity");
                super(null);
                this.activity = r100;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/player/Event$Prepare$PrePrepare;", "Lcom/bytedance/android/livesdk/player/Event$Prepare;", "()V", "getName", "", "live-player-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class PrePrepare extends Prepare {
            public static final PrePrepare INSTANCE = null;

            private PrePrepare() {
                super(null);
            }

            @Override // com.bytedance.android.livesdk.player.Event
            public String getName() {
                return "Prepare.PrePrepare";
            }

            static {
                INSTANCE = new PrePrepare();
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/player/Event$Prepare$RenderViewBound;", "Lcom/bytedance/android/livesdk/player/Event$Prepare;", "()V", "getName", "", "live-player-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class RenderViewBound extends Prepare {
            public static final RenderViewBound INSTANCE = null;

            private RenderViewBound() {
                super(null);
            }

            @Override // com.bytedance.android.livesdk.player.Event
            public String getName() {
                return "Prepare.RenderViewBound";
            }

            static {
                INSTANCE = new RenderViewBound();
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/player/Event$Prepare$Reset;", "Lcom/bytedance/android/livesdk/player/Event$Prepare;", "resolution", "", "(Ljava/lang/String;)V", "getResolution", "()Ljava/lang/String;", "getName", "live-player-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class Reset extends Prepare {
            private final String resolution;

            /* JADX WARN: Multi-variable type inference failed */
            public Reset() {
                this(null, 1, 0 == true ? 1 : 0);
            }

            @Override // com.bytedance.android.livesdk.player.Event
            public String getName() {
                return "Prepare.Reset";
            }

            public final String getResolution() {
                return this.resolution;
            }

            public Reset(String r100) {
                Intrinsics.checkNotNullParameter(r100, "resolution");
                super(null);
                this.resolution = r100;
            }

            public /* synthetic */ Reset(String r100, int r101, DefaultConstructorMarker r102) {
                if ((r101 & 1) == 0) goto L5;
                r100 = "";
            L5:
                this(r100);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/player/Event$Prepare$SurfaceReady;", "Lcom/bytedance/android/livesdk/player/Event$Prepare;", "()V", "getName", "", "live-player-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class SurfaceReady extends Prepare {
            public static final SurfaceReady INSTANCE = null;

            private SurfaceReady() {
                super(null);
            }

            @Override // com.bytedance.android.livesdk.player.Event
            public String getName() {
                return "Prepare.SurfaceReady";
            }

            static {
                INSTANCE = new SurfaceReady();
            }
        }

        private Prepare() {
            super(null);
        }

        public /* synthetic */ Prepare(DefaultConstructorMarker r100) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/player/Event$Release;", "Lcom/bytedance/android/livesdk/player/Event;", "()V", "getName", "", "live-player-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Release extends Event {
        public static final Release INSTANCE = null;

        private Release() {
            super(null);
        }

        @Override // com.bytedance.android.livesdk.player.Event
        public String getName() {
            return "Release";
        }

        static {
            INSTANCE = new Release();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\b\u0010\f\u001a\u00020\rH\u0016J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/player/Event$Start;", "Lcom/bytedance/android/livesdk/player/Event;", "muted", "", "(Z)V", "getMuted", "()Z", "component1", "copy", "equals", "other", "", "getName", "", "hashCode", "", "toString", "live-player-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Start extends Event {
        private final boolean muted;

        public Start() {
            boolean r100 = false;
            this(r100, 1, null);
        }

        public static /* synthetic */ Start copy$default(Start r100, boolean r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.muted;
        L6:
            return r100.copy(r101);
        }

        public final boolean component1() {
            return this.muted;
        }

        public final Start copy(boolean r100) {
            return new Start(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof Start) == true) goto L6;
            return false;
        L6:
            if (this.muted == ((Start) r100).muted) goto L13;
            return false;
        L13:
            return true;
        }

        public int hashCode() {
            boolean r100 = this.muted;
            if (r100 == false) goto L6;
            return 1;
        L6:
            return r100 ? 1 : 0;
        }

        public String toString() {
            return "Start(muted=" + this.muted + ")";
        }

        @Override // com.bytedance.android.livesdk.player.Event
        public String getName() {
            return "Start[muted:" + this.muted + ']';
        }

        public final boolean getMuted() {
            return this.muted;
        }

        public Start(boolean r100) {
            super(null);
            this.muted = r100;
        }

        public /* synthetic */ Start(boolean r100, int r101, DefaultConstructorMarker r102) {
            if ((r101 & 1) == 0) goto L5;
            r100 = false;
        L5:
            this(r100);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/player/Event$Stop;", "Lcom/bytedance/android/livesdk/player/Event;", "()V", "getName", "", "live-player-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Stop extends Event {
        public static final Stop INSTANCE = null;

        private Stop() {
            super(null);
        }

        @Override // com.bytedance.android.livesdk.player.Event
        public String getName() {
            return "Stop";
        }

        static {
            INSTANCE = new Stop();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/player/Event$UnMute;", "Lcom/bytedance/android/livesdk/player/Event;", "()V", "getName", "", "live-player-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class UnMute extends Event {
        public static final UnMute INSTANCE = null;

        private UnMute() {
            super(null);
        }

        @Override // com.bytedance.android.livesdk.player.Event
        public String getName() {
            return "UnMute";
        }

        static {
            INSTANCE = new UnMute();
        }
    }

    private Event() {
    }

    public abstract String getName();

    public /* synthetic */ Event(DefaultConstructorMarker r100) {
        this();
    }
}
