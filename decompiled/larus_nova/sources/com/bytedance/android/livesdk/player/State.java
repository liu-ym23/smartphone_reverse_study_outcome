package com.bytedance.android.livesdk.player;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0006\u0005\u0006\u0007\b\t\nB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u0082\u0001\u0006\u000b\f\r\u000e\u000f\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/player/State;", "", "()V", "getName", "", "Background", "Paused", "Playing", "Preparing", "Released", "Stopped", "Lcom/bytedance/android/livesdk/player/State$Background;", "Lcom/bytedance/android/livesdk/player/State$Paused;", "Lcom/bytedance/android/livesdk/player/State$Playing;", "Lcom/bytedance/android/livesdk/player/State$Preparing;", "Lcom/bytedance/android/livesdk/player/State$Released;", "Lcom/bytedance/android/livesdk/player/State$Stopped;", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class State {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\b\u0010\f\u001a\u00020\rH\u0016J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/player/State$Background;", "Lcom/bytedance/android/livesdk/player/State;", "muted", "", "(Z)V", "getMuted", "()Z", "component1", "copy", "equals", "other", "", "getName", "", "hashCode", "", "toString", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Background extends State {
        private final boolean muted;

        public Background() {
            boolean r100 = false;
            this(r100, 1, null);
        }

        public static /* synthetic */ Background copy$default(Background r100, boolean r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.muted;
        L6:
            return r100.copy(r101);
        }

        public final boolean component1() {
            return this.muted;
        }

        public final Background copy(boolean r100) {
            return new Background(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof Background) == true) goto L6;
            return false;
        L6:
            if (this.muted == ((Background) r100).muted) goto L13;
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
            return "Background(muted=" + this.muted + ")";
        }

        @Override // com.bytedance.android.livesdk.player.State
        public String getName() {
            return "Background[muted:" + this.muted + ']';
        }

        public final boolean getMuted() {
            return this.muted;
        }

        public Background(boolean r100) {
            super(null);
            this.muted = r100;
        }

        public /* synthetic */ Background(boolean r100, int r101, DefaultConstructorMarker r102) {
            if ((r101 & 1) == 0) goto L5;
            r100 = false;
        L5:
            this(r100);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/player/State$Paused;", "Lcom/bytedance/android/livesdk/player/State;", "()V", "getName", "", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Paused extends State {
        public static final Paused INSTANCE = null;

        private Paused() {
            super(null);
        }

        @Override // com.bytedance.android.livesdk.player.State
        public String getName() {
            return "Paused";
        }

        static {
            INSTANCE = new Paused();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\b\u0010\f\u001a\u00020\rH\u0016J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/player/State$Playing;", "Lcom/bytedance/android/livesdk/player/State;", "muted", "", "(Z)V", "getMuted", "()Z", "component1", "copy", "equals", "other", "", "getName", "", "hashCode", "", "toString", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Playing extends State {
        private final boolean muted;

        public Playing() {
            boolean r100 = false;
            this(r100, 1, null);
        }

        public static /* synthetic */ Playing copy$default(Playing r100, boolean r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.muted;
        L6:
            return r100.copy(r101);
        }

        public final boolean component1() {
            return this.muted;
        }

        public final Playing copy(boolean r100) {
            return new Playing(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof Playing) == true) goto L6;
            return false;
        L6:
            if (this.muted == ((Playing) r100).muted) goto L13;
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
            return "Playing(muted=" + this.muted + ")";
        }

        @Override // com.bytedance.android.livesdk.player.State
        public String getName() {
            return "Playing[muted:" + this.muted + ']';
        }

        public final boolean getMuted() {
            return this.muted;
        }

        public Playing(boolean r100) {
            super(null);
            this.muted = r100;
        }

        public /* synthetic */ Playing(boolean r100, int r101, DefaultConstructorMarker r102) {
            if ((r101 & 1) == 0) goto L5;
            r100 = false;
        L5:
            this(r100);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/player/State$Preparing;", "Lcom/bytedance/android/livesdk/player/State;", "renderViewBound", "", "surfaceReady", "playerPrepared", "firstFrame", "(ZZZZ)V", "getFirstFrame", "()Z", "getPlayerPrepared", "getRenderViewBound", "getSurfaceReady", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "getName", "", "hashCode", "", "toString", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Preparing extends State {
        private final boolean firstFrame;
        private final boolean playerPrepared;
        private final boolean renderViewBound;
        private final boolean surfaceReady;

        public Preparing() {
            this(false, false, false, false, 15, null);
        }

        public static /* synthetic */ Preparing copy$default(Preparing r100, boolean r101, boolean r102, boolean r103, boolean r104, int r105, Object r106) {
            if ((r105 & 1) == 0) goto L6;
            r101 = r100.renderViewBound;
        L6:
            if ((r105 & 2) == 0) goto L9;
            r102 = r100.surfaceReady;
        L9:
            if ((r105 & 4) == 0) goto L12;
            r103 = r100.playerPrepared;
        L12:
            if ((r105 & 8) == 0) goto L15;
            r104 = r100.firstFrame;
        L15:
            return r100.copy(r101, r102, r103, r104);
        }

        public final boolean component1() {
            return this.renderViewBound;
        }

        public final boolean component2() {
            return this.surfaceReady;
        }

        public final boolean component3() {
            return this.playerPrepared;
        }

        public final boolean component4() {
            return this.firstFrame;
        }

        public final Preparing copy(boolean r100, boolean r101, boolean r102, boolean r103) {
            return new Preparing(r100, r101, r102, r103);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof Preparing) == false) goto L14;
            Preparing r101 = (Preparing) r100;
            if (this.renderViewBound == r101.renderViewBound) goto L8;
            return false;
        L8:
            if (this.surfaceReady == r101.surfaceReady) goto L10;
            return false;
        L10:
            if (this.playerPrepared == r101.playerPrepared) goto L12;
            return false;
        L12:
            if (this.firstFrame == r101.firstFrame) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r0v5, types: [int] */
        /* JADX WARN: Type inference failed for: r0v7, types: [int] */
        /* JADX WARN: Type inference failed for: r0v8 */
        /* JADX WARN: Type inference failed for: r0v9 */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v3, types: [int] */
        /* JADX WARN: Type inference failed for: r2v5 */
        /* JADX WARN: Type inference failed for: r2v6 */
        /* JADX WARN: Type inference failed for: r2v7 */
        /* JADX WARN: Type inference failed for: r2v8 */
        public int hashCode() {
            boolean r100 = this.renderViewBound;
            ?? r101 = 1;
            ?? r102 = r100;
            if (r100 == false) goto L5;
            r102 = 1;
        L5:
            int r103 = r102 * 31;
            boolean r104 = this.surfaceReady;
            ?? r105 = r104;
            if (r104 == false) goto L8;
            r105 = 1;
        L8:
            int r106 = (r103 + r105) * 31;
            boolean r107 = this.playerPrepared;
            ?? r108 = r107;
            if (r107 == false) goto L11;
            r108 = 1;
        L11:
            int r109 = (r106 + r108) * 31;
            boolean r110 = this.firstFrame;
            if (r110 == true) goto L16;
            r101 = r110;
        L16:
            return r109 + r101;
        }

        public String toString() {
            return "Preparing(renderViewBound=" + this.renderViewBound + ", surfaceReady=" + this.surfaceReady + ", playerPrepared=" + this.playerPrepared + ", firstFrame=" + this.firstFrame + ")";
        }

        @Override // com.bytedance.android.livesdk.player.State
        public String getName() {
            return "Prepare[renderViewBound:" + this.renderViewBound + ", surfaceReady:" + this.surfaceReady + ", playerPrepared:" + this.playerPrepared + ", firstFrame:" + this.firstFrame + ']';
        }

        public final boolean getFirstFrame() {
            return this.firstFrame;
        }

        public final boolean getPlayerPrepared() {
            return this.playerPrepared;
        }

        public final boolean getRenderViewBound() {
            return this.renderViewBound;
        }

        public final boolean getSurfaceReady() {
            return this.surfaceReady;
        }

        public Preparing(boolean r100, boolean r101, boolean r102, boolean r103) {
            super(null);
            this.renderViewBound = r100;
            this.surfaceReady = r101;
            this.playerPrepared = r102;
            this.firstFrame = r103;
        }

        public /* synthetic */ Preparing(boolean r100, boolean r101, boolean r102, boolean r103, int r104, DefaultConstructorMarker r105) {
            if ((r104 & 1) == 0) goto L6;
            r100 = false;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r101 = false;
        L9:
            if ((r104 & 4) == 0) goto L12;
            r102 = false;
        L12:
            if ((r104 & 8) == 0) goto L14;
            r103 = false;
        L14:
            this(r100, r101, r102, r103);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/player/State$Released;", "Lcom/bytedance/android/livesdk/player/State;", "()V", "getName", "", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Released extends State {
        public static final Released INSTANCE = null;

        private Released() {
            super(null);
        }

        @Override // com.bytedance.android.livesdk.player.State
        public String getName() {
            return "Released";
        }

        static {
            INSTANCE = new Released();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/player/State$Stopped;", "Lcom/bytedance/android/livesdk/player/State;", "()V", "getName", "", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Stopped extends State {
        public static final Stopped INSTANCE = null;

        private Stopped() {
            super(null);
        }

        @Override // com.bytedance.android.livesdk.player.State
        public String getName() {
            return "Stopped";
        }

        static {
            INSTANCE = new Stopped();
        }
    }

    private State() {
    }

    public abstract String getName();

    public /* synthetic */ State(DefaultConstructorMarker r100) {
        this();
    }
}
