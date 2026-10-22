package android.os.collector.user;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.collector.StepOSCollectAtomID;
import android.os.collector.base.Field;
import android.os.collector.base.StepOSBaseEntity;
import android.os.collector.base.StepOSSubFieldHolder;
import android.os.collector.user.StepOSMediaFileData;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntSupplier;
import java.util.function.LongConsumer;
import java.util.function.LongSupplier;
import java.util.function.Supplier;

/* loaded from: classes.dex */
public final class StepOSMediaFileData extends StepOSBaseEntity {
    public static final Parcelable.Creator<StepOSMediaFileData> CREATOR = creatorOf(new StepOSBaseEntity.EntityFactory() { // from class: android.os.collector.user.StepOSMediaFileData$$ExternalSyntheticLambda0
        @Override // android.os.collector.base.StepOSBaseEntity.EntityFactory
        public final StepOSBaseEntity create() {
            return new StepOSMediaFileData();
        }
    }, new IntFunction() { // from class: android.os.collector.user.StepOSMediaFileData$$ExternalSyntheticLambda1
        @Override // java.util.function.IntFunction
        public final Object apply(int i) {
            return StepOSMediaFileData.lambda$static$4(i);
        }
    });
    public int mBatchSize;
    public List<MediaFileItem> mItems;

    public static final class MediaFileItem implements StepOSSubFieldHolder, Parcelable {
        public static final Parcelable.Creator<MediaFileItem> CREATOR = new Parcelable.Creator<MediaFileItem>() { // from class: android.os.collector.user.StepOSMediaFileData.MediaFileItem.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public MediaFileItem createFromParcel(Parcel in) {
                return new MediaFileItem(in);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public MediaFileItem[] newArray(int size) {
                return new MediaFileItem[size];
            }
        };
        public long mCreatedTimeMs;
        public String mFileName;
        public String mFilePath;
        public long mFileSize;
        public int mFileType;
        public String mMimeType;
        public String mSourcePackage;
        public String mUri;

        public MediaFileItem() {
        }

        public MediaFileItem(int fileType, String uri, String fileName, String filePath, long fileSize, String mimeType, String sourcePackage, long createdTimeMs) {
            this.mFileType = fileType;
            this.mUri = uri;
            this.mFileName = fileName;
            this.mFilePath = filePath;
            this.mFileSize = fileSize;
            this.mMimeType = mimeType;
            this.mSourcePackage = sourcePackage;
            this.mCreatedTimeMs = createdTimeMs;
        }

        @Override // android.os.collector.base.StepOSSubFieldHolder
        public Field[] subFields() {
            return new Field[]{Field.ofInt("file_type", new IntSupplier() { // from class: android.os.collector.user.StepOSMediaFileData$MediaFileItem$$ExternalSyntheticLambda0
                @Override // java.util.function.IntSupplier
                public final int getAsInt() {
                    return this.f$0.lambda$subFields$0();
                }
            }, new IntConsumer() { // from class: android.os.collector.user.StepOSMediaFileData$MediaFileItem$$ExternalSyntheticLambda7
                @Override // java.util.function.IntConsumer
                public final void accept(int i) {
                    this.f$0.lambda$subFields$1(i);
                }
            }), Field.ofString("uri", new Supplier() { // from class: android.os.collector.user.StepOSMediaFileData$MediaFileItem$$ExternalSyntheticLambda8
                @Override // java.util.function.Supplier
                public final Object get() {
                    return this.f$0.lambda$subFields$2();
                }
            }, new Consumer() { // from class: android.os.collector.user.StepOSMediaFileData$MediaFileItem$$ExternalSyntheticLambda9
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.f$0.lambda$subFields$3((String) obj);
                }
            }), Field.ofString("file_name", new Supplier() { // from class: android.os.collector.user.StepOSMediaFileData$MediaFileItem$$ExternalSyntheticLambda10
                @Override // java.util.function.Supplier
                public final Object get() {
                    return this.f$0.lambda$subFields$4();
                }
            }, new Consumer() { // from class: android.os.collector.user.StepOSMediaFileData$MediaFileItem$$ExternalSyntheticLambda11
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.f$0.lambda$subFields$5((String) obj);
                }
            }), Field.ofString("file_path", new Supplier() { // from class: android.os.collector.user.StepOSMediaFileData$MediaFileItem$$ExternalSyntheticLambda12
                @Override // java.util.function.Supplier
                public final Object get() {
                    return this.f$0.lambda$subFields$6();
                }
            }, new Consumer() { // from class: android.os.collector.user.StepOSMediaFileData$MediaFileItem$$ExternalSyntheticLambda13
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.f$0.lambda$subFields$7((String) obj);
                }
            }), Field.ofLong("file_size", new LongSupplier() { // from class: android.os.collector.user.StepOSMediaFileData$MediaFileItem$$ExternalSyntheticLambda14
                @Override // java.util.function.LongSupplier
                public final long getAsLong() {
                    return this.f$0.lambda$subFields$8();
                }
            }, new LongConsumer() { // from class: android.os.collector.user.StepOSMediaFileData$MediaFileItem$$ExternalSyntheticLambda15
                @Override // java.util.function.LongConsumer
                public final void accept(long j) {
                    this.f$0.lambda$subFields$9(j);
                }
            }), Field.ofString("mime_type", new Supplier() { // from class: android.os.collector.user.StepOSMediaFileData$MediaFileItem$$ExternalSyntheticLambda1
                @Override // java.util.function.Supplier
                public final Object get() {
                    return this.f$0.lambda$subFields$10();
                }
            }, new Consumer() { // from class: android.os.collector.user.StepOSMediaFileData$MediaFileItem$$ExternalSyntheticLambda2
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.f$0.lambda$subFields$11((String) obj);
                }
            }), Field.ofString("source_package", new Supplier() { // from class: android.os.collector.user.StepOSMediaFileData$MediaFileItem$$ExternalSyntheticLambda3
                @Override // java.util.function.Supplier
                public final Object get() {
                    return this.f$0.lambda$subFields$12();
                }
            }, new Consumer() { // from class: android.os.collector.user.StepOSMediaFileData$MediaFileItem$$ExternalSyntheticLambda4
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.f$0.lambda$subFields$13((String) obj);
                }
            }), Field.ofLong("created_time_ms", new LongSupplier() { // from class: android.os.collector.user.StepOSMediaFileData$MediaFileItem$$ExternalSyntheticLambda5
                @Override // java.util.function.LongSupplier
                public final long getAsLong() {
                    return this.f$0.lambda$subFields$14();
                }
            }, new LongConsumer() { // from class: android.os.collector.user.StepOSMediaFileData$MediaFileItem$$ExternalSyntheticLambda6
                @Override // java.util.function.LongConsumer
                public final void accept(long j) {
                    this.f$0.lambda$subFields$15(j);
                }
            })};
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ int lambda$subFields$0() {
            return this.mFileType;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$subFields$1(int v) {
            this.mFileType = v;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ String lambda$subFields$2() {
            return this.mUri;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$subFields$3(String v) {
            this.mUri = v;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ String lambda$subFields$4() {
            return this.mFileName;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$subFields$5(String v) {
            this.mFileName = v;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ String lambda$subFields$6() {
            return this.mFilePath;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$subFields$7(String v) {
            this.mFilePath = v;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ long lambda$subFields$8() {
            return this.mFileSize;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$subFields$9(long v) {
            this.mFileSize = v;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ String lambda$subFields$10() {
            return this.mMimeType;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$subFields$11(String v) {
            this.mMimeType = v;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ String lambda$subFields$12() {
            return this.mSourcePackage;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$subFields$13(String v) {
            this.mSourcePackage = v;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ long lambda$subFields$14() {
            return this.mCreatedTimeMs;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$subFields$15(long v) {
            this.mCreatedTimeMs = v;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("MediaFileItem{");
            Field[] fs = subFields();
            for (int i = 0; i < fs.length; i++) {
                if (i > 0) {
                    sb.append(", ");
                }
                sb.append(fs[i].name).append('=').append(fs[i].getter.get());
            }
            sb.append('}');
            return sb.toString();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.mFileType);
            dest.writeString(this.mUri);
            dest.writeString(this.mFileName);
            dest.writeString(this.mFilePath);
            dest.writeLong(this.mFileSize);
            dest.writeString(this.mMimeType);
            dest.writeString(this.mSourcePackage);
            dest.writeLong(this.mCreatedTimeMs);
        }

        private MediaFileItem(Parcel in) {
            this.mFileType = in.readInt();
            this.mUri = in.readString();
            this.mFileName = in.readString();
            this.mFilePath = in.readString();
            this.mFileSize = in.readLong();
            this.mMimeType = in.readString();
            this.mSourcePackage = in.readString();
            this.mCreatedTimeMs = in.readLong();
        }
    }

    public StepOSMediaFileData() {
        super(2, StepOSCollectAtomID.USER_DOMAIN_TAG_MEDIA_FILE);
    }

    public StepOSMediaFileData(int batchSize, List<MediaFileItem> items) {
        this();
        this.mBatchSize = batchSize;
        this.mItems = items;
    }

    @Override // android.os.collector.base.StepOSBaseEntity
    protected Field[] fields() {
        return new Field[]{Field.ofInt("batch_size", new IntSupplier() { // from class: android.os.collector.user.StepOSMediaFileData$$ExternalSyntheticLambda2
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return this.f$0.lambda$fields$0();
            }
        }, new IntConsumer() { // from class: android.os.collector.user.StepOSMediaFileData$$ExternalSyntheticLambda3
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                this.f$0.lambda$fields$1(i);
            }
        }), Field.ofMessageList("items", new Supplier() { // from class: android.os.collector.user.StepOSMediaFileData$$ExternalSyntheticLambda4
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.lambda$fields$2();
            }
        }, new Consumer() { // from class: android.os.collector.user.StepOSMediaFileData$$ExternalSyntheticLambda5
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$fields$3((List) obj);
            }
        }, new Supplier() { // from class: android.os.collector.user.StepOSMediaFileData$$ExternalSyntheticLambda6
            @Override // java.util.function.Supplier
            public final Object get() {
                return new StepOSMediaFileData.MediaFileItem();
            }
        }, new Function() { // from class: android.os.collector.user.StepOSMediaFileData$$ExternalSyntheticLambda7
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((StepOSMediaFileData.MediaFileItem) obj).subFields();
            }
        })};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$fields$0() {
        return this.mBatchSize;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$1(int v) {
        this.mBatchSize = v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List lambda$fields$2() {
        return this.mItems;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fields$3(List v) {
        this.mItems = v;
    }

    static /* synthetic */ StepOSMediaFileData[] lambda$static$4(int x$0) {
        return new StepOSMediaFileData[x$0];
    }
}
