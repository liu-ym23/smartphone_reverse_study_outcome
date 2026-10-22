package android.os.collector.system;

import android.os.Parcelable;
import android.os.collector.base.Field;
import android.os.collector.base.StepOSBaseEntity;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

/* loaded from: classes.dex */
public final class StepOSAppTagStateData extends StepOSBaseEntity {
    public static final Parcelable.Creator<StepOSAppTagStateData> CREATOR = creatorOf(new StepOSBaseEntity.EntityFactory() { // from class: android.os.collector.system.StepOSAppTagStateData$$ExternalSyntheticLambda18
        @Override // android.os.collector.base.StepOSBaseEntity.EntityFactory
        public final StepOSBaseEntity create() {
            return new StepOSAppTagStateData();
        }
    }, new IntFunction() { // from class: android.os.collector.system.StepOSAppTagStateData$$ExternalSyntheticLambda19
        @Override // java.util.function.IntFunction
        public final Object apply(int i) {
            return StepOSAppTagStateData.lambda$static$18(i);
        }
    });
    public boolean mCameraLive;
    public boolean mFloatOther;
    public String mPackageName;
    public int mUid;
    public boolean mVideoChat;
    public boolean mVideoChatFloat;
    public boolean mVideoPlayFloat;
    public boolean mVoiceChat;
    public boolean mVoiceChatFloat;

    public StepOSAppTagStateData() {
        super(1, 15);
    }

    public StepOSAppTagStateData(String packageName, int uid, boolean voiceChat, boolean videoChat, boolean cameraLive, boolean voiceChatFloat, boolean videoChatFloat, boolean videoPlayFloat, boolean floatOther) {
        this();
        this.mPackageName = packageName;
        this.mUid = uid;
        this.mVoiceChat = voiceChat;
        this.mVideoChat = videoChat;
        this.mCameraLive = cameraLive;
        this.mVoiceChatFloat = voiceChatFloat;
        this.mVideoChatFloat = videoChatFloat;
        this.mVideoPlayFloat = videoPlayFloat;
        this.mFloatOther = floatOther;
    }

    @Override // android.os.collector.base.StepOSBaseEntity
    protected Field[] fields() {
        return new Field[]{Field.ofString("package_name", new Supplier() { // from class: android.os.collector.system.StepOSAppTagStateData$$ExternalSyntheticLambda0
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.lambda$fields$0();
            }
        }, new Consumer() { // from class: android.os.collector.system.StepOSAppTagStateData$$ExternalSyntheticLambda9
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$1((String) obj);
            }
        }), Field.ofInt("uid", new IntSupplier() { // from class: android.os.collector.system.StepOSAppTagStateData$$ExternalSyntheticLambda10
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$2();
            }
        }, new IntConsumer() { // from class: android.os.collector.system.StepOSAppTagStateData$$ExternalSyntheticLambda11
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$3(i);
            }
        }), Field.ofBool("voice_chat", new BooleanSupplier() { // from class: android.os.collector.system.StepOSAppTagStateData$$ExternalSyntheticLambda12
            @Override // java.util.function.BooleanSupplier
            public final boolean getAsBoolean() {
                return this.f$0.lambda$fields$4();
            }
        }, new Consumer() { // from class: android.os.collector.system.StepOSAppTagStateData$$ExternalSyntheticLambda13
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$5((Boolean) obj);
            }
        }), Field.ofBool("video_chat", new BooleanSupplier() { // from class: android.os.collector.system.StepOSAppTagStateData$$ExternalSyntheticLambda14
            @Override // java.util.function.BooleanSupplier
            public final boolean getAsBoolean() {
                return this.f$0.lambda$fields$6();
            }
        }, new Consumer() { // from class: android.os.collector.system.StepOSAppTagStateData$$ExternalSyntheticLambda15
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$7((Boolean) obj);
            }
        }), Field.ofBool("camera_live", new BooleanSupplier() { // from class: android.os.collector.system.StepOSAppTagStateData$$ExternalSyntheticLambda16
            @Override // java.util.function.BooleanSupplier
            public final boolean getAsBoolean() {
                return this.f$0.lambda$fields$8();
            }
        }, new Consumer() { // from class: android.os.collector.system.StepOSAppTagStateData$$ExternalSyntheticLambda17
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$9((Boolean) obj);
            }
        }), Field.ofBool("voice_chat_float", new BooleanSupplier() { // from class: android.os.collector.system.StepOSAppTagStateData$$ExternalSyntheticLambda1
            @Override // java.util.function.BooleanSupplier
            public final boolean getAsBoolean() {
                return this.f$0.lambda$fields$10();
            }
        }, new Consumer() { // from class: android.os.collector.system.StepOSAppTagStateData$$ExternalSyntheticLambda2
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$11((Boolean) obj);
            }
        }), Field.ofBool("video_chat_float", new BooleanSupplier() { // from class: android.os.collector.system.StepOSAppTagStateData$$ExternalSyntheticLambda3
            @Override // java.util.function.BooleanSupplier
            public final boolean getAsBoolean() {
                return this.f$0.lambda$fields$12();
            }
        }, new Consumer() { // from class: android.os.collector.system.StepOSAppTagStateData$$ExternalSyntheticLambda4
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$13((Boolean) obj);
            }
        }), Field.ofBool("video_play_float", new BooleanSupplier() { // from class: android.os.collector.system.StepOSAppTagStateData$$ExternalSyntheticLambda5
            @Override // java.util.function.BooleanSupplier
            public final boolean getAsBoolean() {
                return this.f$0.lambda$fields$14();
            }
        }, new Consumer() { // from class: android.os.collector.system.StepOSAppTagStateData$$ExternalSyntheticLambda6
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$15((Boolean) obj);
            }
        }), Field.ofBool("float_other", new BooleanSupplier() { // from class: android.os.collector.system.StepOSAppTagStateData$$ExternalSyntheticLambda7
            @Override // java.util.function.BooleanSupplier
            public final boolean getAsBoolean() {
                return this.f$0.lambda$fields$16();
            }
        }, new Consumer() { // from class: android.os.collector.system.StepOSAppTagStateData$$ExternalSyntheticLambda8
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$17((Boolean) obj);
            }
        })};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$fields$0() {
        return this.mPackageName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$1(String v) {
        this.mPackageName = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$fields$2() {
        return this.mUid;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$3(int v) {
        this.mUid = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$fields$4() {
        return this.mVoiceChat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$5(Boolean v) {
        this.mVoiceChat = v.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$fields$6() {
        return this.mVideoChat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$7(Boolean v) {
        this.mVideoChat = v.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$fields$8() {
        return this.mCameraLive;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$9(Boolean v) {
        this.mCameraLive = v.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$fields$10() {
        return this.mVoiceChatFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$11(Boolean v) {
        this.mVoiceChatFloat = v.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$fields$12() {
        return this.mVideoChatFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$13(Boolean v) {
        this.mVideoChatFloat = v.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$fields$14() {
        return this.mVideoPlayFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$15(Boolean v) {
        this.mVideoPlayFloat = v.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$fields$16() {
        return this.mFloatOther;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$17(Boolean v) {
        this.mFloatOther = v.booleanValue();
    }

    static /* synthetic */ StepOSAppTagStateData[] lambda$static$18(int x$0) {
        return new StepOSAppTagStateData[x$0];
    }
}
