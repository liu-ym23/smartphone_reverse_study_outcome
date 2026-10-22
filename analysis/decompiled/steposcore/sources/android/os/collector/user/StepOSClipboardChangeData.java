package android.os.collector.user;

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
public final class StepOSClipboardChangeData extends StepOSBaseEntity {
    public static final Parcelable.Creator<StepOSClipboardChangeData> CREATOR = creatorOf(new StepOSBaseEntity.EntityFactory() { // from class: android.os.collector.user.StepOSClipboardChangeData$$ExternalSyntheticLambda18
        @Override // android.os.collector.base.StepOSBaseEntity.EntityFactory
        public final StepOSBaseEntity create() {
            return new StepOSClipboardChangeData();
        }
    }, new IntFunction() { // from class: android.os.collector.user.StepOSClipboardChangeData$$ExternalSyntheticLambda19
        @Override // java.util.function.IntFunction
        public final Object apply(int i) {
            return StepOSClipboardChangeData.lambda$static$18(i);
        }
    });
    public boolean mContainsHtml;
    public boolean mContainsUri;
    public String mContent;
    public int mItemCount;
    public String mMimeTypesCsv;
    public int mSensitiveHints;
    public String mSourcePkg;
    public int mTextLengthChars;
    public long mWallClockMs;

    public StepOSClipboardChangeData() {
        super(2, StepOSCollectAtomID.USER_DOMAIN_TAG_CLIPBOARD_CHANGE);
    }

    public StepOSClipboardChangeData(String sourcePkg, String mimeTypesCsv, int itemCount, int textLengthChars, boolean containsHtml, boolean containsUri, int sensitiveHints, long wallClockMs, String content) {
        this();
        this.mSourcePkg = sourcePkg;
        this.mMimeTypesCsv = mimeTypesCsv;
        this.mItemCount = itemCount;
        this.mTextLengthChars = textLengthChars;
        this.mContainsHtml = containsHtml;
        this.mContainsUri = containsUri;
        this.mSensitiveHints = sensitiveHints;
        this.mWallClockMs = wallClockMs;
        this.mContent = content;
    }

    @Override // android.os.collector.base.StepOSBaseEntity
    protected Field[] fields() {
        return new Field[]{Field.ofString("source_pkg", new Supplier() { // from class: android.os.collector.user.StepOSClipboardChangeData$$ExternalSyntheticLambda0
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.lambda$fields$0();
            }
        }, new Consumer() { // from class: android.os.collector.user.StepOSClipboardChangeData$$ExternalSyntheticLambda9
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$1((String) obj);
            }
        }), Field.ofString("mime_types_csv", new Supplier() { // from class: android.os.collector.user.StepOSClipboardChangeData$$ExternalSyntheticLambda10
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.lambda$fields$2();
            }
        }, new Consumer() { // from class: android.os.collector.user.StepOSClipboardChangeData$$ExternalSyntheticLambda11
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$3((String) obj);
            }
        }), Field.ofInt("item_count", new IntSupplier() { // from class: android.os.collector.user.StepOSClipboardChangeData$$ExternalSyntheticLambda12
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$4();
            }
        }, new IntConsumer() { // from class: android.os.collector.user.StepOSClipboardChangeData$$ExternalSyntheticLambda13
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$5(i);
            }
        }), Field.ofInt("text_length_chars", new IntSupplier() { // from class: android.os.collector.user.StepOSClipboardChangeData$$ExternalSyntheticLambda14
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$6();
            }
        }, new IntConsumer() { // from class: android.os.collector.user.StepOSClipboardChangeData$$ExternalSyntheticLambda15
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$7(i);
            }
        }), Field.ofBool("contains_html", new BooleanSupplier() { // from class: android.os.collector.user.StepOSClipboardChangeData$$ExternalSyntheticLambda16
            @Override // java.util.function.BooleanSupplier
            public final boolean getAsBoolean() {
                return this.f$0.lambda$fields$8();
            }
        }, new Consumer() { // from class: android.os.collector.user.StepOSClipboardChangeData$$ExternalSyntheticLambda17
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$9((Boolean) obj);
            }
        }), Field.ofBool("contains_uri", new BooleanSupplier() { // from class: android.os.collector.user.StepOSClipboardChangeData$$ExternalSyntheticLambda1
            @Override // java.util.function.BooleanSupplier
            public final boolean getAsBoolean() {
                return this.f$0.lambda$fields$10();
            }
        }, new Consumer() { // from class: android.os.collector.user.StepOSClipboardChangeData$$ExternalSyntheticLambda2
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$11((Boolean) obj);
            }
        }), Field.ofInt("sensitive_hints", new IntSupplier() { // from class: android.os.collector.user.StepOSClipboardChangeData$$ExternalSyntheticLambda3
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$12();
            }
        }, new IntConsumer() { // from class: android.os.collector.user.StepOSClipboardChangeData$$ExternalSyntheticLambda4
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$13(i);
            }
        }), Field.ofLong("wall_clock_ms", new LongSupplier() { // from class: android.os.collector.user.StepOSClipboardChangeData$$ExternalSyntheticLambda5
            @Override // java.util.function.LongSupplier
            public final long getAsLong() {
                return this.f$0.lambda$fields$14();
            }
        }, new LongConsumer() { // from class: android.os.collector.user.StepOSClipboardChangeData$$ExternalSyntheticLambda6
            @Override // java.util.function.LongConsumer
            public final void accept(long j) {
                this.f$0.lambda$fields$15(j);
            }
        }), Field.ofString("content", new Supplier() { // from class: android.os.collector.user.StepOSClipboardChangeData$$ExternalSyntheticLambda7
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.lambda$fields$16();
            }
        }, new Consumer() { // from class: android.os.collector.user.StepOSClipboardChangeData$$ExternalSyntheticLambda8
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$17((String) obj);
            }
        })};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$fields$0() {
        return this.mSourcePkg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$1(String v) {
        this.mSourcePkg = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$fields$2() {
        return this.mMimeTypesCsv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$3(String v) {
        this.mMimeTypesCsv = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$fields$4() {
        return this.mItemCount;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$5(int v) {
        this.mItemCount = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$fields$6() {
        return this.mTextLengthChars;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$7(int v) {
        this.mTextLengthChars = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$fields$8() {
        return this.mContainsHtml;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$9(Boolean v) {
        this.mContainsHtml = v.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$fields$10() {
        return this.mContainsUri;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$11(Boolean v) {
        this.mContainsUri = v.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$fields$12() {
        return this.mSensitiveHints;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$13(int v) {
        this.mSensitiveHints = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ long lambda$fields$14() {
        return this.mWallClockMs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$15(long v) {
        this.mWallClockMs = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$fields$16() {
        return this.mContent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$17(String v) {
        this.mContent = v;
    }

    static /* synthetic */ StepOSClipboardChangeData[] lambda$static$18(int x$0) {
        return new StepOSClipboardChangeData[x$0];
    }
}
