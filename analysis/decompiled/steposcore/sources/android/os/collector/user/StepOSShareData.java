package android.os.collector.user;

import android.os.Parcelable;
import android.os.collector.StepOSCollectAtomID;
import android.os.collector.base.Field;
import android.os.collector.base.StepOSBaseEntity;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

/* loaded from: classes.dex */
public final class StepOSShareData extends StepOSBaseEntity {
    public static final Parcelable.Creator<StepOSShareData> CREATOR = creatorOf(new StepOSBaseEntity.EntityFactory() { // from class: android.os.collector.user.StepOSShareData$$ExternalSyntheticLambda18
        @Override // android.os.collector.base.StepOSBaseEntity.EntityFactory
        public final StepOSBaseEntity create() {
            return new StepOSShareData();
        }
    }, new IntFunction() { // from class: android.os.collector.user.StepOSShareData$$ExternalSyntheticLambda19
        @Override // java.util.function.IntFunction
        public final Object apply(int i) {
            return StepOSShareData.lambda$static$18(i);
        }
    });
    public String mAction;
    public String mCallerPkg;
    public String[] mClipItems;
    public String mExtraSubject;
    public String mExtraText;
    public String mMimeType;
    public int mSourceType;
    public String[] mStreamUris;
    public String mTargetPkg;

    public StepOSShareData() {
        super(2, StepOSCollectAtomID.USER_DOMAIN_TAG_SHARE);
    }

    public StepOSShareData(int sourceType, String callerPkg, String targetPkg, String action, String mimeType, String extraText, String[] streamUris, String extraSubject, String[] clipItems) {
        this();
        this.mSourceType = sourceType;
        this.mCallerPkg = callerPkg;
        this.mTargetPkg = targetPkg;
        this.mAction = action;
        this.mMimeType = mimeType;
        this.mExtraText = extraText;
        this.mStreamUris = streamUris;
        this.mExtraSubject = extraSubject;
        this.mClipItems = clipItems;
    }

    @Override // android.os.collector.base.StepOSBaseEntity
    protected Field[] fields() {
        return new Field[]{Field.ofInt("source_type", new IntSupplier() { // from class: android.os.collector.user.StepOSShareData$$ExternalSyntheticLambda0
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$0();
            }
        }, new IntConsumer() { // from class: android.os.collector.user.StepOSShareData$$ExternalSyntheticLambda9
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$1(i);
            }
        }), Field.ofString("caller_pkg", new Supplier() { // from class: android.os.collector.user.StepOSShareData$$ExternalSyntheticLambda10
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.lambda$fields$2();
            }
        }, new Consumer() { // from class: android.os.collector.user.StepOSShareData$$ExternalSyntheticLambda11
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$3((String) obj);
            }
        }), Field.ofString("target_pkg", new Supplier() { // from class: android.os.collector.user.StepOSShareData$$ExternalSyntheticLambda12
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.lambda$fields$4();
            }
        }, new Consumer() { // from class: android.os.collector.user.StepOSShareData$$ExternalSyntheticLambda13
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$5((String) obj);
            }
        }), Field.ofString("action", new Supplier() { // from class: android.os.collector.user.StepOSShareData$$ExternalSyntheticLambda14
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.lambda$fields$6();
            }
        }, new Consumer() { // from class: android.os.collector.user.StepOSShareData$$ExternalSyntheticLambda15
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$7((String) obj);
            }
        }), Field.ofString("mime_type", new Supplier() { // from class: android.os.collector.user.StepOSShareData$$ExternalSyntheticLambda16
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.lambda$fields$8();
            }
        }, new Consumer() { // from class: android.os.collector.user.StepOSShareData$$ExternalSyntheticLambda17
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$9((String) obj);
            }
        }), Field.ofString("extra_text", new Supplier() { // from class: android.os.collector.user.StepOSShareData$$ExternalSyntheticLambda1
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.lambda$fields$10();
            }
        }, new Consumer() { // from class: android.os.collector.user.StepOSShareData$$ExternalSyntheticLambda2
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$11((String) obj);
            }
        }), Field.ofStringArray("stream_uris", new Supplier() { // from class: android.os.collector.user.StepOSShareData$$ExternalSyntheticLambda3
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.lambda$fields$12();
            }
        }, new Consumer() { // from class: android.os.collector.user.StepOSShareData$$ExternalSyntheticLambda4
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$13((String[]) obj);
            }
        }), Field.ofString("extra_subject", new Supplier() { // from class: android.os.collector.user.StepOSShareData$$ExternalSyntheticLambda5
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.lambda$fields$14();
            }
        }, new Consumer() { // from class: android.os.collector.user.StepOSShareData$$ExternalSyntheticLambda6
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$15((String) obj);
            }
        }), Field.ofStringArray("clip_items", new Supplier() { // from class: android.os.collector.user.StepOSShareData$$ExternalSyntheticLambda7
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.lambda$fields$16();
            }
        }, new Consumer() { // from class: android.os.collector.user.StepOSShareData$$ExternalSyntheticLambda8
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$17((String[]) obj);
            }
        })};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$fields$0() {
        return this.mSourceType;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$1(int v) {
        this.mSourceType = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$fields$2() {
        return this.mCallerPkg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$3(String v) {
        this.mCallerPkg = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$fields$4() {
        return this.mTargetPkg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$5(String v) {
        this.mTargetPkg = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$fields$6() {
        return this.mAction;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$7(String v) {
        this.mAction = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$fields$8() {
        return this.mMimeType;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$9(String v) {
        this.mMimeType = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$fields$10() {
        return this.mExtraText;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$11(String v) {
        this.mExtraText = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String[] lambda$fields$12() {
        return this.mStreamUris;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$13(String[] v) {
        this.mStreamUris = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$fields$14() {
        return this.mExtraSubject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$15(String v) {
        this.mExtraSubject = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String[] lambda$fields$16() {
        return this.mClipItems;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$17(String[] v) {
        this.mClipItems = v;
    }

    static /* synthetic */ StepOSShareData[] lambda$static$18(int x$0) {
        return new StepOSShareData[x$0];
    }
}
