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
public final class StepOSMediaMetadataData extends StepOSBaseEntity {
    public static final Parcelable.Creator<StepOSMediaMetadataData> CREATOR = creatorOf(new StepOSBaseEntity.EntityFactory() { // from class: android.os.collector.user.StepOSMediaMetadataData$$ExternalSyntheticLambda20
        @Override // android.os.collector.base.StepOSBaseEntity.EntityFactory
        public final StepOSBaseEntity create() {
            return new StepOSMediaMetadataData();
        }
    }, new IntFunction() { // from class: android.os.collector.user.StepOSMediaMetadataData$$ExternalSyntheticLambda21
        @Override // java.util.function.IntFunction
        public final Object apply(int i) {
            return StepOSMediaMetadataData.lambda$static$20(i);
        }
    });
    public String mAlbum;
    public String mArtist;
    public int mDurationMs;
    public int mFirstActionIconResId;
    public String mPackageName;
    public int mPositionMs;
    public int mRatingStyle;
    public float mRatingValue;
    public int mState;
    public String mTitle;

    public StepOSMediaMetadataData() {
        super(2, StepOSCollectAtomID.USER_DOMAIN_TAG_MEDIA_METADATA);
    }

    public StepOSMediaMetadataData(String packageName, String title, String artist, String album, int durationMs, int positionMs, int state, int ratingStyle, float ratingValue, int firstActionIconResId) {
        this();
        this.mPackageName = packageName;
        this.mTitle = title;
        this.mArtist = artist;
        this.mAlbum = album;
        this.mDurationMs = durationMs;
        this.mPositionMs = positionMs;
        this.mState = state;
        this.mRatingStyle = ratingStyle;
        this.mRatingValue = ratingValue;
        this.mFirstActionIconResId = firstActionIconResId;
    }

    @Override // android.os.collector.base.StepOSBaseEntity
    protected Field[] fields() {
        return new Field[]{Field.ofString("package_name", new Supplier() { // from class: android.os.collector.user.StepOSMediaMetadataData$$ExternalSyntheticLambda0
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.lambda$fields$0();
            }
        }, new Consumer() { // from class: android.os.collector.user.StepOSMediaMetadataData$$ExternalSyntheticLambda11
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$1((String) obj);
            }
        }), Field.ofString("title", new Supplier() { // from class: android.os.collector.user.StepOSMediaMetadataData$$ExternalSyntheticLambda12
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.lambda$fields$2();
            }
        }, new Consumer() { // from class: android.os.collector.user.StepOSMediaMetadataData$$ExternalSyntheticLambda13
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$3((String) obj);
            }
        }), Field.ofString("artist", new Supplier() { // from class: android.os.collector.user.StepOSMediaMetadataData$$ExternalSyntheticLambda14
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.lambda$fields$4();
            }
        }, new Consumer() { // from class: android.os.collector.user.StepOSMediaMetadataData$$ExternalSyntheticLambda15
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$5((String) obj);
            }
        }), Field.ofString("album", new Supplier() { // from class: android.os.collector.user.StepOSMediaMetadataData$$ExternalSyntheticLambda16
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.lambda$fields$6();
            }
        }, new Consumer() { // from class: android.os.collector.user.StepOSMediaMetadataData$$ExternalSyntheticLambda17
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$7((String) obj);
            }
        }), Field.ofInt("duration_ms", new IntSupplier() { // from class: android.os.collector.user.StepOSMediaMetadataData$$ExternalSyntheticLambda18
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$8();
            }
        }, new IntConsumer() { // from class: android.os.collector.user.StepOSMediaMetadataData$$ExternalSyntheticLambda19
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$9(i);
            }
        }), Field.ofInt("position_ms", new IntSupplier() { // from class: android.os.collector.user.StepOSMediaMetadataData$$ExternalSyntheticLambda1
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$10();
            }
        }, new IntConsumer() { // from class: android.os.collector.user.StepOSMediaMetadataData$$ExternalSyntheticLambda2
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$11(i);
            }
        }), Field.ofInt("state", new IntSupplier() { // from class: android.os.collector.user.StepOSMediaMetadataData$$ExternalSyntheticLambda3
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$12();
            }
        }, new IntConsumer() { // from class: android.os.collector.user.StepOSMediaMetadataData$$ExternalSyntheticLambda4
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$13(i);
            }
        }), Field.ofInt("rating_style", new IntSupplier() { // from class: android.os.collector.user.StepOSMediaMetadataData$$ExternalSyntheticLambda5
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$14();
            }
        }, new IntConsumer() { // from class: android.os.collector.user.StepOSMediaMetadataData$$ExternalSyntheticLambda6
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$15(i);
            }
        }), Field.ofFloat("rating_value", new Supplier() { // from class: android.os.collector.user.StepOSMediaMetadataData$$ExternalSyntheticLambda7
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.lambda$fields$16();
            }
        }, new Consumer() { // from class: android.os.collector.user.StepOSMediaMetadataData$$ExternalSyntheticLambda8
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$17((Float) obj);
            }
        }), Field.ofInt("first_action_icon_res_id", new IntSupplier() { // from class: android.os.collector.user.StepOSMediaMetadataData$$ExternalSyntheticLambda9
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$18();
            }
        }, new IntConsumer() { // from class: android.os.collector.user.StepOSMediaMetadataData$$ExternalSyntheticLambda10
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$19(i);
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
    public /* synthetic */ String lambda$fields$2() {
        return this.mTitle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$3(String v) {
        this.mTitle = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$fields$4() {
        return this.mArtist;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$5(String v) {
        this.mArtist = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$fields$6() {
        return this.mAlbum;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$7(String v) {
        this.mAlbum = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$fields$8() {
        return this.mDurationMs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$9(int v) {
        this.mDurationMs = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$fields$10() {
        return this.mPositionMs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$11(int v) {
        this.mPositionMs = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$fields$12() {
        return this.mState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$13(int v) {
        this.mState = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$fields$14() {
        return this.mRatingStyle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$15(int v) {
        this.mRatingStyle = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Float lambda$fields$16() {
        return Float.valueOf(this.mRatingValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$17(Float v) {
        this.mRatingValue = v.floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$fields$18() {
        return this.mFirstActionIconResId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$19(int v) {
        this.mFirstActionIconResId = v;
    }

    static /* synthetic */ StepOSMediaMetadataData[] lambda$static$20(int x$0) {
        return new StepOSMediaMetadataData[x$0];
    }
}
