package com.bytedance.android.livesdk.interactivity.api.degrade.model;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
public interface DegradeSceneLevel {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/degrade/model/DegradeSceneLevel$AudienceExpLevel;", "", "Lcom/bytedance/android/livesdk/interactivity/api/degrade/model/DegradeSceneLevel;", "Normal", "Degrade", "Enhance", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum AudienceExpLevel extends Enum<AudienceExpLevel> implements DegradeSceneLevel {
        public static final AudienceExpLevel Degrade = null;
        public static final AudienceExpLevel Enhance = null;
        public static final AudienceExpLevel Normal = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ AudienceExpLevel[] f133101a = null;

        static {
            AudienceExpLevel r100 = new AudienceExpLevel("Normal", 0);
            Normal = r100;
            AudienceExpLevel r101 = new AudienceExpLevel("Degrade", 1);
            Degrade = r101;
            AudienceExpLevel r102 = new AudienceExpLevel("Enhance", 2);
            Enhance = r102;
            f133101a = new AudienceExpLevel[]{r100, r101, r102};
        }

        public static AudienceExpLevel valueOf(String r100) {
            return (AudienceExpLevel) r27.a.a(AudienceExpLevel.class, r100);
        }

        public static AudienceExpLevel[] values() {
            return (AudienceExpLevel[]) f133101a.clone();
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeSceneLevel
        public String logName() {
            return a.a(this);
        }

        public AudienceExpLevel(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/degrade/model/DegradeSceneLevel$Default;", "", "Lcom/bytedance/android/livesdk/interactivity/api/degrade/model/DegradeSceneLevel;", UserProfileEvent.POSITION_NONE, "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Default extends Enum<Default> implements DegradeSceneLevel {
        public static final Default NONE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Default[] f133102a = null;

        static {
            Default r100 = new Default();
            NONE = r100;
            f133102a = new Default[]{r100};
        }

        public static Default valueOf(String r100) {
            return (Default) r27.a.a(Default.class, r100);
        }

        public static Default[] values() {
            return (Default[]) f133102a.clone();
        }

        public Default() {
            super(UserProfileEvent.POSITION_NONE, 0);
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeSceneLevel
        public String logName() {
            return a.a(this);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/degrade/model/DegradeSceneLevel$Ecom;", "", "Lcom/bytedance/android/livesdk/interactivity/api/degrade/model/DegradeSceneLevel;", "HAPPEN", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Ecom extends Enum<Ecom> implements DegradeSceneLevel {
        public static final Ecom HAPPEN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Ecom[] f133103a = null;

        static {
            Ecom r100 = new Ecom();
            HAPPEN = r100;
            f133103a = new Ecom[]{r100};
        }

        public static Ecom valueOf(String r100) {
            return (Ecom) r27.a.a(Ecom.class, r100);
        }

        public static Ecom[] values() {
            return (Ecom[]) f133103a.clone();
        }

        public Ecom() {
            super("HAPPEN", 0);
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeSceneLevel
        public String logName() {
            return a.a(this);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/degrade/model/DegradeSceneLevel$EnterRoomDuration;", "", "Lcom/bytedance/android/livesdk/interactivity/api/degrade/model/DegradeSceneLevel;", "InEnterRoomDuration", "OutEnterRoomDuration", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum EnterRoomDuration extends Enum<EnterRoomDuration> implements DegradeSceneLevel {
        public static final EnterRoomDuration InEnterRoomDuration = null;
        public static final EnterRoomDuration OutEnterRoomDuration = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ EnterRoomDuration[] f133104a = null;

        static {
            EnterRoomDuration r100 = new EnterRoomDuration("InEnterRoomDuration", 0);
            InEnterRoomDuration = r100;
            EnterRoomDuration r101 = new EnterRoomDuration("OutEnterRoomDuration", 1);
            OutEnterRoomDuration = r101;
            f133104a = new EnterRoomDuration[]{r100, r101};
        }

        public static EnterRoomDuration valueOf(String r100) {
            return (EnterRoomDuration) r27.a.a(EnterRoomDuration.class, r100);
        }

        public static EnterRoomDuration[] values() {
            return (EnterRoomDuration[]) f133104a.clone();
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeSceneLevel
        public String logName() {
            return a.a(this);
        }

        public EnterRoomDuration(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/degrade/model/DegradeSceneLevel$Game;", "", "Lcom/bytedance/android/livesdk/interactivity/api/degrade/model/DegradeSceneLevel;", "HAPPEN", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Game extends Enum<Game> implements DegradeSceneLevel {
        public static final Game HAPPEN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Game[] f133105a = null;

        static {
            Game r100 = new Game();
            HAPPEN = r100;
            f133105a = new Game[]{r100};
        }

        public static Game valueOf(String r100) {
            return (Game) r27.a.a(Game.class, r100);
        }

        public static Game[] values() {
            return (Game[]) f133105a.clone();
        }

        public Game() {
            super("HAPPEN", 0);
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeSceneLevel
        public String logName() {
            return a.a(this);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/degrade/model/DegradeSceneLevel$LowPerformancePhone;", "", "Lcom/bytedance/android/livesdk/interactivity/api/degrade/model/DegradeSceneLevel;", "HAPPEN", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum LowPerformancePhone extends Enum<LowPerformancePhone> implements DegradeSceneLevel {
        public static final LowPerformancePhone HAPPEN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LowPerformancePhone[] f133106a = null;

        static {
            LowPerformancePhone r100 = new LowPerformancePhone();
            HAPPEN = r100;
            f133106a = new LowPerformancePhone[]{r100};
        }

        public static LowPerformancePhone valueOf(String r100) {
            return (LowPerformancePhone) r27.a.a(LowPerformancePhone.class, r100);
        }

        public static LowPerformancePhone[] values() {
            return (LowPerformancePhone[]) f133106a.clone();
        }

        public LowPerformancePhone() {
            super("HAPPEN", 0);
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeSceneLevel
        public String logName() {
            return a.a(this);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/degrade/model/DegradeSceneLevel$PerformanceFrame;", "", "Lcom/bytedance/android/livesdk/interactivity/api/degrade/model/DegradeSceneLevel;", "LEVEL_ONE", "LEVEL_TWO", "LOW_BATTERY", "ANCHOR_OVERHEAT", "CLOSE", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum PerformanceFrame extends Enum<PerformanceFrame> implements DegradeSceneLevel {
        public static final PerformanceFrame ANCHOR_OVERHEAT = null;
        public static final PerformanceFrame CLOSE = null;
        public static final PerformanceFrame LEVEL_ONE = null;
        public static final PerformanceFrame LEVEL_TWO = null;
        public static final PerformanceFrame LOW_BATTERY = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ PerformanceFrame[] f133107a = null;

        static {
            PerformanceFrame r100 = new PerformanceFrame("LEVEL_ONE", 0);
            LEVEL_ONE = r100;
            PerformanceFrame r101 = new PerformanceFrame("LEVEL_TWO", 1);
            LEVEL_TWO = r101;
            PerformanceFrame r102 = new PerformanceFrame("LOW_BATTERY", 2);
            LOW_BATTERY = r102;
            PerformanceFrame r103 = new PerformanceFrame("ANCHOR_OVERHEAT", 3);
            ANCHOR_OVERHEAT = r103;
            PerformanceFrame r104 = new PerformanceFrame("CLOSE", 4);
            CLOSE = r104;
            f133107a = new PerformanceFrame[]{r100, r101, r102, r103, r104};
        }

        public static PerformanceFrame valueOf(String r100) {
            return (PerformanceFrame) r27.a.a(PerformanceFrame.class, r100);
        }

        public static PerformanceFrame[] values() {
            return (PerformanceFrame[]) f133107a.clone();
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeSceneLevel
        public String logName() {
            return a.a(this);
        }

        public PerformanceFrame(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\tR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/degrade/model/DegradeSceneLevel$PlatformFlowLikeDegradeLevel;", "", "Lcom/bytedance/android/livesdk/interactivity/api/degrade/model/DegradeSceneLevel;", "", "level", "I", "getLevel", "()I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "LEVEL_ONE", "LEVEL_TWO", "LEVEL_THREE", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum PlatformFlowLikeDegradeLevel extends Enum<PlatformFlowLikeDegradeLevel> implements DegradeSceneLevel {
        public static final a Companion = null;
        public static final PlatformFlowLikeDegradeLevel LEVEL_ONE = null;
        public static final PlatformFlowLikeDegradeLevel LEVEL_THREE = null;
        public static final PlatformFlowLikeDegradeLevel LEVEL_TWO = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ PlatformFlowLikeDegradeLevel[] f133108a = null;
        private final int level;

        public static final class a {
            public a() {
            }
        }

        static {
            PlatformFlowLikeDegradeLevel r100 = new PlatformFlowLikeDegradeLevel("LEVEL_ONE", 0, 1);
            LEVEL_ONE = r100;
            PlatformFlowLikeDegradeLevel r101 = new PlatformFlowLikeDegradeLevel("LEVEL_TWO", 1, 2);
            LEVEL_TWO = r101;
            PlatformFlowLikeDegradeLevel r102 = new PlatformFlowLikeDegradeLevel("LEVEL_THREE", 2, 3);
            LEVEL_THREE = r102;
            f133108a = new PlatformFlowLikeDegradeLevel[]{r100, r101, r102};
            Companion = new a();
        }

        public static PlatformFlowLikeDegradeLevel valueOf(String r100) {
            return (PlatformFlowLikeDegradeLevel) r27.a.a(PlatformFlowLikeDegradeLevel.class, r100);
        }

        public static PlatformFlowLikeDegradeLevel[] values() {
            return (PlatformFlowLikeDegradeLevel[]) f133108a.clone();
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeSceneLevel
        public String logName() {
            return a.a(this);
        }

        public final int getLevel() {
            return this.level;
        }

        public PlatformFlowLikeDegradeLevel(String r100, int r101, int r102) {
            super(r100, r101);
            this.level = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\tR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/degrade/model/DegradeSceneLevel$PlatformTapLikeDegradeLevel;", "", "Lcom/bytedance/android/livesdk/interactivity/api/degrade/model/DegradeSceneLevel;", "", "level", "I", "getLevel", "()I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "LEVEL_ONE", "LEVEL_TWO", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum PlatformTapLikeDegradeLevel extends Enum<PlatformTapLikeDegradeLevel> implements DegradeSceneLevel {
        public static final a Companion = null;
        public static final PlatformTapLikeDegradeLevel LEVEL_ONE = null;
        public static final PlatformTapLikeDegradeLevel LEVEL_TWO = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ PlatformTapLikeDegradeLevel[] f133109a = null;
        private final int level;

        public static final class a {
            public a() {
            }
        }

        static {
            PlatformTapLikeDegradeLevel r100 = new PlatformTapLikeDegradeLevel("LEVEL_ONE", 0, 1);
            LEVEL_ONE = r100;
            PlatformTapLikeDegradeLevel r101 = new PlatformTapLikeDegradeLevel("LEVEL_TWO", 1, 2);
            LEVEL_TWO = r101;
            f133109a = new PlatformTapLikeDegradeLevel[]{r100, r101};
            Companion = new a();
        }

        public static PlatformTapLikeDegradeLevel valueOf(String r100) {
            return (PlatformTapLikeDegradeLevel) r27.a.a(PlatformTapLikeDegradeLevel.class, r100);
        }

        public static PlatformTapLikeDegradeLevel[] values() {
            return (PlatformTapLikeDegradeLevel[]) f133109a.clone();
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.degrade.model.DegradeSceneLevel
        public String logName() {
            return a.a(this);
        }

        public final int getLevel() {
            return this.level;
        }

        public PlatformTapLikeDegradeLevel(String r100, int r101, int r102) {
            super(r100, r101);
            this.level = r102;
        }
    }

    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static String a(DegradeSceneLevel r100) {
            if ((r100 instanceof Enum) == false) goto L6;
            return ((Enum) r100).name();
        L6:
            return r100.getClass().getSimpleName();
        }
    }

    String logName();
}
