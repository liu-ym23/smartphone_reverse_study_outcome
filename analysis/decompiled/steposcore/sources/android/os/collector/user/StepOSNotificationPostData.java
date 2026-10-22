package android.os.collector.user;

import android.hardware.display.StepOSDisplayManager;
import android.os.Parcelable;
import android.os.collector.StepOSCollectAtomID;
import android.os.collector.base.Field;
import android.os.collector.base.StepOSBaseEntity;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntSupplier;
import java.util.function.LongConsumer;
import java.util.function.LongSupplier;
import java.util.function.Supplier;

/* loaded from: classes.dex */
public final class StepOSNotificationPostData extends StepOSBaseEntity {
    public static final Parcelable.Creator<StepOSNotificationPostData> CREATOR = creatorOf(new StepOSBaseEntity.EntityFactory() { // from class: android.os.collector.user.StepOSNotificationPostData$$ExternalSyntheticLambda0
        @Override // android.os.collector.base.StepOSBaseEntity.EntityFactory
        public final StepOSBaseEntity create() {
            return new StepOSNotificationPostData();
        }
    }, new IntFunction() { // from class: android.os.collector.user.StepOSNotificationPostData$$ExternalSyntheticLambda1
        @Override // java.util.function.IntFunction
        public final Object apply(int i) {
            return StepOSNotificationPostData.lambda$static$20(i);
        }
    });
    public String mCategory;
    public String mChannelId;
    public int mFlags;
    public String mGroupKey;
    public boolean mIsOngoing;
    public String mPackageName;
    public long mPostTimeMs;
    public String mSubText;
    public String mText;
    public String mTitle;

    public StepOSNotificationPostData() {
        super(2, StepOSCollectAtomID.USER_DOMAIN_TAG_NOTIFICATION_POST);
    }

    public StepOSNotificationPostData(String packageName, String channelId, String category, long postTimeMs, boolean isOngoing, String groupKey, String title, String text, String subText, int flags) {
        this();
        this.mPackageName = packageName;
        this.mChannelId = channelId;
        this.mCategory = category;
        this.mPostTimeMs = postTimeMs;
        this.mIsOngoing = isOngoing;
        this.mGroupKey = groupKey;
        this.mTitle = title;
        this.mText = text;
        this.mSubText = subText;
        this.mFlags = flags;
    }

    @Override // android.os.collector.base.StepOSBaseEntity
    protected Field[] fields() {
        return new Field[]{Field.ofString("package_name", new Supplier() { // from class: android.os.collector.user.StepOSNotificationPostData$$ExternalSyntheticLambda2
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.lambda$fields$0();
            }
        }, new Consumer() { // from class: android.os.collector.user.StepOSNotificationPostData$$ExternalSyntheticLambda13
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$1((String) obj);
            }
        }), Field.ofString("channel_id", new Supplier() { // from class: android.os.collector.user.StepOSNotificationPostData$$ExternalSyntheticLambda14
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.lambda$fields$2();
            }
        }, new Consumer() { // from class: android.os.collector.user.StepOSNotificationPostData$$ExternalSyntheticLambda15
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$3((String) obj);
            }
        }), Field.ofString("category", new Supplier() { // from class: android.os.collector.user.StepOSNotificationPostData$$ExternalSyntheticLambda16
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.lambda$fields$4();
            }
        }, new Consumer() { // from class: android.os.collector.user.StepOSNotificationPostData$$ExternalSyntheticLambda17
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$5((String) obj);
            }
        }), Field.ofLong("post_time_ms", new LongSupplier() { // from class: android.os.collector.user.StepOSNotificationPostData$$ExternalSyntheticLambda18
            @Override // java.util.function.LongSupplier
            public final long getAsLong() {
                return this.f$0.lambda$fields$6();
            }
        }, new LongConsumer() { // from class: android.os.collector.user.StepOSNotificationPostData$$ExternalSyntheticLambda19
            @Override // java.util.function.LongConsumer
            public final void accept(long j) {
                this.f$0.lambda$fields$7(j);
            }
        }), Field.ofBool("is_ongoing", new BooleanSupplier() { // from class: android.os.collector.user.StepOSNotificationPostData$$ExternalSyntheticLambda20
            @Override // java.util.function.BooleanSupplier
            public final boolean getAsBoolean() {
                return this.f$0.lambda$fields$8();
            }
        }, new Consumer() { // from class: android.os.collector.user.StepOSNotificationPostData$$ExternalSyntheticLambda21
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$9((Boolean) obj);
            }
        }), Field.ofString("group_key", new Supplier() { // from class: android.os.collector.user.StepOSNotificationPostData$$ExternalSyntheticLambda3
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.lambda$fields$10();
            }
        }, new Consumer() { // from class: android.os.collector.user.StepOSNotificationPostData$$ExternalSyntheticLambda4
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$11((String) obj);
            }
        }), Field.ofString("title", new Supplier() { // from class: android.os.collector.user.StepOSNotificationPostData$$ExternalSyntheticLambda5
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.lambda$fields$12();
            }
        }, new Consumer() { // from class: android.os.collector.user.StepOSNotificationPostData$$ExternalSyntheticLambda6
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$13((String) obj);
            }
        }), Field.ofString(StepOSDisplayManager.BACK_SCREEN_BASIC_TYPE_TEXT, new Supplier() { // from class: android.os.collector.user.StepOSNotificationPostData$$ExternalSyntheticLambda7
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.lambda$fields$14();
            }
        }, new Consumer() { // from class: android.os.collector.user.StepOSNotificationPostData$$ExternalSyntheticLambda8
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$15((String) obj);
            }
        }), Field.ofString("sub_text", new Supplier() { // from class: android.os.collector.user.StepOSNotificationPostData$$ExternalSyntheticLambda9
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.lambda$fields$16();
            }
        }, new Consumer() { // from class: android.os.collector.user.StepOSNotificationPostData$$ExternalSyntheticLambda10
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$17((String) obj);
            }
        }), Field.ofInt("flags", new IntSupplier() { // from class: android.os.collector.user.StepOSNotificationPostData$$ExternalSyntheticLambda11
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$18();
            }
        }, new IntConsumer() { // from class: android.os.collector.user.StepOSNotificationPostData$$ExternalSyntheticLambda12
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
        return this.mChannelId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$3(String v) {
        this.mChannelId = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$fields$4() {
        return this.mCategory;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$5(String v) {
        this.mCategory = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ long lambda$fields$6() {
        return this.mPostTimeMs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$7(long v) {
        this.mPostTimeMs = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$fields$8() {
        return this.mIsOngoing;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$9(Boolean v) {
        this.mIsOngoing = v.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$fields$10() {
        return this.mGroupKey;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$11(String v) {
        this.mGroupKey = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$fields$12() {
        return this.mTitle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$13(String v) {
        this.mTitle = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$fields$14() {
        return this.mText;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$15(String v) {
        this.mText = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$fields$16() {
        return this.mSubText;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$17(String v) {
        this.mSubText = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$fields$18() {
        return this.mFlags;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$19(int v) {
        this.mFlags = v;
    }

    static /* synthetic */ StepOSNotificationPostData[] lambda$static$20(int x$0) {
        return new StepOSNotificationPostData[x$0];
    }
}
