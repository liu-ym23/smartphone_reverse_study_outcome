package com.stepos.digitalwellbeing.server;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.stepos.digitalwellbeing.server.data.Category;
import com.stepos.digitalwellbeing.server.data.CategoryLimitInfo;
import com.stepos.digitalwellbeing.server.data.CategoryUsingTimeStats;
import com.stepos.digitalwellbeing.server.data.DataToken;
import com.stepos.digitalwellbeing.server.data.GlobalLimitInfo;
import com.stepos.digitalwellbeing.server.data.NotificationTimesStats;
import com.stepos.digitalwellbeing.server.data.PackageLimitInfo;
import com.stepos.digitalwellbeing.server.data.PackageNotificationTimesStats;
import com.stepos.digitalwellbeing.server.data.PackageUsingTimeStats;
import com.stepos.digitalwellbeing.server.data.PeriodLimitInfo;
import com.stepos.digitalwellbeing.server.data.PickupTimesStats;
import com.stepos.digitalwellbeing.server.data.RawPeriodInfo;
import com.stepos.digitalwellbeing.server.data.StatsDataSet;
import com.stepos.digitalwellbeing.server.data.UsingTimeStats;
import com.stepos.digitalwellbeing.server.data.WhitelistAppInfo;
import java.util.List;

/* loaded from: classes.dex */
public interface IDigitalWellbeingInterface extends IInterface {
    public static final String DESCRIPTOR = "com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface";

    public static class Default implements IDigitalWellbeingInterface {
        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public long addCategoryPeriod(long j5, RawPeriodInfo rawPeriodInfo) {
            return 0L;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public long addCategoryPeriodWithAdmin(long j5, RawPeriodInfo rawPeriodInfo, long j6) {
            return 0L;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public long addGlobalPeriod(RawPeriodInfo rawPeriodInfo) {
            return 0L;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public long addGlobalPeriodWithAdmin(RawPeriodInfo rawPeriodInfo, long j5) {
            return 0L;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public long addPackagePeriod(String str, RawPeriodInfo rawPeriodInfo) {
            return 0L;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public long addPackagePeriodWithAdmin(String str, RawPeriodInfo rawPeriodInfo, long j5) {
            return 0L;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public long addPeriod(long j5, RawPeriodInfo rawPeriodInfo) {
            return 0L;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public long addPeriodWithAdmin(long j5, RawPeriodInfo rawPeriodInfo, long j6) {
            return 0L;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public void addWhitelistApp(WhitelistAppInfo whitelistAppInfo) {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public void clearAdminLimit(long j5) {
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public Category[] getCategories(boolean z5) {
            return null;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public PeriodLimitInfo[] getCategoriesPeriodLimitInfo(long j5) {
            return null;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public Category getCategory(boolean z5, int i5) {
            return null;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public PeriodLimitInfo getCategoryPeriodLimitInfo(long j5, long j6) {
            return null;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public RawPeriodInfo[] getCategoryRawPeriod(long j5) {
            return null;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public RawPeriodInfo[] getCategoryRawPeriodWithAdmin(long j5, long j6) {
            return null;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public CategoryUsingTimeStats[] getCategoryUsingTimeStats(int i5, DataToken dataToken) {
            return null;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public long getCurrentAdmin() {
            return 0L;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public PeriodLimitInfo getGlobalPeriodLimitInfo(long j5) {
            return null;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public RawPeriodInfo[] getGlobalRawPeriod() {
            return null;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public RawPeriodInfo[] getGlobalRawPeriodWithAdmin(long j5) {
            return null;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public CategoryLimitInfo[] getLimitedCategoriesInfo(boolean z5) {
            return null;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public CategoryLimitInfo getLimitedCategoryInfo(boolean z5, int i5) {
            return null;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public GlobalLimitInfo getLimitedGlobalInfo(boolean z5) {
            return null;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public PackageLimitInfo getLimitedPackageInfo(boolean z5, String str) {
            return null;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public PackageLimitInfo[] getLimitedPackagesInfo(boolean z5) {
            return null;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public PackageNotificationTimesStats[] getPackageNotificationTimesStats(int i5, String str, DataToken dataToken) {
            return null;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public PeriodLimitInfo getPackagePeriodLimitInfo(String str, long j5) {
            return null;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public RawPeriodInfo[] getPackageRawPeriod(String str) {
            return null;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public RawPeriodInfo[] getPackageRawPeriodWithAdmin(String str, long j5) {
            return null;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public PackageUsingTimeStats[] getPackageUsingTimeStats(int i5, String str, DataToken dataToken) {
            return null;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public PackageNotificationTimesStats[] getPackagesNotificationTimesStats(int i5, DataToken dataToken) {
            return null;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public PeriodLimitInfo[] getPackagesPeriodLimitInfo(long j5) {
            return null;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public PackageUsingTimeStats[] getPackagesUsingTimeStats(int i5, DataToken dataToken) {
            return null;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public NotificationTimesStats[] getPhoneNotificationTimesStats(int i5, DataToken dataToken) {
            return null;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public UsingTimeStats[] getPhoneUsingTimeStats(int i5, DataToken dataToken) {
            return null;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public PickupTimesStats[] getPickupTimesStats(int i5, DataToken dataToken) {
            return null;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public RawPeriodInfo[] getRawPeriod(long j5) {
            return null;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public StatsDataSet[] getStatsDataSets(DataToken dataToken) {
            return null;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public List<WhitelistAppInfo> getWhitelistAppList() {
            return null;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public List<WhitelistAppInfo> getWhitelistAppListWithAdmin(long j5) {
            return null;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public void init() {
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public PeriodLimitInfo initCategoryPeriodLimitInfo(long j5, long j6, boolean z5) {
            return null;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public PeriodLimitInfo initGlobalPeriodLimitInfo() {
            return null;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public PeriodLimitInfo initGlobalPeriodLimitInfoWithAdmin(long j5) {
            return null;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public PeriodLimitInfo initPackagePeriodLimitInfo(String str, long j5, boolean z5) {
            return null;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public boolean isEnable() {
            return false;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public boolean isPackageLimitable(String str) {
            return false;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public DataToken queryUsageData(int i5, boolean z5) {
            return null;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public DataToken queryUsageDataSet(int i5, boolean z5) {
            return null;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public long removeCategoryPeriod(long j5, long j6) {
            return 0L;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public long removeCategoryPeriodWithAdmin(long j5, long j6, long j7) {
            return 0L;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public long removeGlobalPeriod(long j5) {
            return 0L;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public long removeGlobalPeriodWithAdmin(long j5, long j6) {
            return 0L;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public long removePackagePeriod(String str, long j5) {
            return 0L;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public long removePackagePeriodWithAdmin(String str, long j5, long j6) {
            return 0L;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public long removePeriod(long j5, long j6) {
            return 0L;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public long removePeriodWithAdmin(long j5, long j6, long j7) {
            return 0L;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public void removeWhitelistApp(WhitelistAppInfo whitelistAppInfo) {
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public boolean setCategoryLimitTime(int i5, int i6, long j5, long j6, boolean z5, boolean z6) {
            return false;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public boolean setCategoryLimitTimeWithAdmin(int i5, int i6, long j5, long j6, boolean z5, boolean z6, long j7, boolean z7) {
            return false;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public PeriodLimitInfo setCategoryPeriodLimit(long j5, boolean z5, boolean z6) {
            return null;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public PeriodLimitInfo setCategoryPeriodLimitWithAdmin(long j5, boolean z5, boolean z6, long j6, boolean z7) {
            return null;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public void setCurrentAdmin(long j5) {
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public void setEnable(boolean z5) {
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public boolean setGlobalLimitTime(int i5, long j5, long j6, boolean z5, boolean z6) {
            return false;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public boolean setGlobalLimitTimeWithAdmin(int i5, long j5, long j6, boolean z5, boolean z6, long j7, boolean z7) {
            return false;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public PeriodLimitInfo setGlobalPeriodLimit(boolean z5, boolean z6) {
            return null;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public PeriodLimitInfo setGlobalPeriodLimitWithAdmin(boolean z5, boolean z6, long j5) {
            return null;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public boolean setPackageLimitTime(int i5, String str, long j5, long j6, boolean z5, boolean z6) {
            return false;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public boolean setPackageLimitTimeWithAdmin(int i5, String str, long j5, long j6, boolean z5, boolean z6, long j7, boolean z7) {
            return false;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public PeriodLimitInfo setPackagePeriodLimit(String str, boolean z5, boolean z6) {
            return null;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public PeriodLimitInfo setPackagePeriodLimitWithAdmin(String str, boolean z5, boolean z6, long j5, boolean z7) {
            return null;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public long updateCategoryPeriod(long j5, RawPeriodInfo rawPeriodInfo) {
            return 0L;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public long updateCategoryPeriodWithAdmin(long j5, RawPeriodInfo rawPeriodInfo, long j6) {
            return 0L;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public long updateGlobalPeriod(RawPeriodInfo rawPeriodInfo) {
            return 0L;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public long updateGlobalPeriodWithAdmin(RawPeriodInfo rawPeriodInfo, long j5) {
            return 0L;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public long updatePackagePeriod(String str, RawPeriodInfo rawPeriodInfo) {
            return 0L;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public long updatePackagePeriodWithAdmin(String str, RawPeriodInfo rawPeriodInfo, long j5) {
            return 0L;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public long updatePeriod(long j5, RawPeriodInfo rawPeriodInfo) {
            return 0L;
        }

        @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
        public long updatePeriodWithAdmin(long j5, RawPeriodInfo rawPeriodInfo, long j6) {
            return 0L;
        }
    }

    public static abstract class Stub extends Binder implements IDigitalWellbeingInterface {
        static final int TRANSACTION_addCategoryPeriod = 55;
        static final int TRANSACTION_addCategoryPeriodWithAdmin = 56;
        static final int TRANSACTION_addGlobalPeriod = 57;
        static final int TRANSACTION_addGlobalPeriodWithAdmin = 58;
        static final int TRANSACTION_addPackagePeriod = 53;
        static final int TRANSACTION_addPackagePeriodWithAdmin = 54;
        static final int TRANSACTION_addPeriod = 51;
        static final int TRANSACTION_addPeriodWithAdmin = 52;
        static final int TRANSACTION_addWhitelistApp = 78;
        static final int TRANSACTION_clearAdminLimit = 77;
        static final int TRANSACTION_getCategories = 12;
        static final int TRANSACTION_getCategoriesPeriodLimitInfo = 36;
        static final int TRANSACTION_getCategory = 13;
        static final int TRANSACTION_getCategoryPeriodLimitInfo = 34;
        static final int TRANSACTION_getCategoryRawPeriod = 48;
        static final int TRANSACTION_getCategoryRawPeriodWithAdmin = 47;
        static final int TRANSACTION_getCategoryUsingTimeStats = 10;
        static final int TRANSACTION_getCurrentAdmin = 28;
        static final int TRANSACTION_getGlobalPeriodLimitInfo = 37;
        static final int TRANSACTION_getGlobalRawPeriod = 50;
        static final int TRANSACTION_getGlobalRawPeriodWithAdmin = 49;
        static final int TRANSACTION_getLimitedCategoriesInfo = 22;
        static final int TRANSACTION_getLimitedCategoryInfo = 24;
        static final int TRANSACTION_getLimitedGlobalInfo = 25;
        static final int TRANSACTION_getLimitedPackageInfo = 23;
        static final int TRANSACTION_getLimitedPackagesInfo = 21;
        static final int TRANSACTION_getPackageNotificationTimesStats = 8;
        static final int TRANSACTION_getPackagePeriodLimitInfo = 33;
        static final int TRANSACTION_getPackageRawPeriod = 46;
        static final int TRANSACTION_getPackageRawPeriodWithAdmin = 45;
        static final int TRANSACTION_getPackageUsingTimeStats = 9;
        static final int TRANSACTION_getPackagesNotificationTimesStats = 7;
        static final int TRANSACTION_getPackagesPeriodLimitInfo = 35;
        static final int TRANSACTION_getPackagesUsingTimeStats = 6;
        static final int TRANSACTION_getPhoneNotificationTimesStats = 4;
        static final int TRANSACTION_getPhoneUsingTimeStats = 3;
        static final int TRANSACTION_getPickupTimesStats = 5;
        static final int TRANSACTION_getRawPeriod = 44;
        static final int TRANSACTION_getStatsDataSets = 11;
        static final int TRANSACTION_getWhitelistAppList = 81;
        static final int TRANSACTION_getWhitelistAppListWithAdmin = 80;
        static final int TRANSACTION_init = 14;
        static final int TRANSACTION_initCategoryPeriodLimitInfo = 30;
        static final int TRANSACTION_initGlobalPeriodLimitInfo = 32;
        static final int TRANSACTION_initGlobalPeriodLimitInfoWithAdmin = 31;
        static final int TRANSACTION_initPackagePeriodLimitInfo = 29;
        static final int TRANSACTION_isEnable = 75;
        static final int TRANSACTION_isPackageLimitable = 26;
        static final int TRANSACTION_queryUsageData = 2;
        static final int TRANSACTION_queryUsageDataSet = 1;
        static final int TRANSACTION_removeCategoryPeriod = 63;
        static final int TRANSACTION_removeCategoryPeriodWithAdmin = 64;
        static final int TRANSACTION_removeGlobalPeriod = 65;
        static final int TRANSACTION_removeGlobalPeriodWithAdmin = 66;
        static final int TRANSACTION_removePackagePeriod = 61;
        static final int TRANSACTION_removePackagePeriodWithAdmin = 62;
        static final int TRANSACTION_removePeriod = 59;
        static final int TRANSACTION_removePeriodWithAdmin = 60;
        static final int TRANSACTION_removeWhitelistApp = 79;
        static final int TRANSACTION_setCategoryLimitTime = 16;
        static final int TRANSACTION_setCategoryLimitTimeWithAdmin = 19;
        static final int TRANSACTION_setCategoryPeriodLimit = 39;
        static final int TRANSACTION_setCategoryPeriodLimitWithAdmin = 42;
        static final int TRANSACTION_setCurrentAdmin = 27;
        static final int TRANSACTION_setEnable = 76;
        static final int TRANSACTION_setGlobalLimitTime = 17;
        static final int TRANSACTION_setGlobalLimitTimeWithAdmin = 20;
        static final int TRANSACTION_setGlobalPeriodLimit = 40;
        static final int TRANSACTION_setGlobalPeriodLimitWithAdmin = 43;
        static final int TRANSACTION_setPackageLimitTime = 15;
        static final int TRANSACTION_setPackageLimitTimeWithAdmin = 18;
        static final int TRANSACTION_setPackagePeriodLimit = 38;
        static final int TRANSACTION_setPackagePeriodLimitWithAdmin = 41;
        static final int TRANSACTION_updateCategoryPeriod = 71;
        static final int TRANSACTION_updateCategoryPeriodWithAdmin = 72;
        static final int TRANSACTION_updateGlobalPeriod = 73;
        static final int TRANSACTION_updateGlobalPeriodWithAdmin = 74;
        static final int TRANSACTION_updatePackagePeriod = 69;
        static final int TRANSACTION_updatePackagePeriodWithAdmin = 70;
        static final int TRANSACTION_updatePeriod = 67;
        static final int TRANSACTION_updatePeriodWithAdmin = 68;

        private static class Proxy implements IDigitalWellbeingInterface {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
            public long addCategoryPeriod(long j5, RawPeriodInfo rawPeriodInfo) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDigitalWellbeingInterface.DESCRIPTOR);
                    parcelObtain.writeLong(j5);
                    a.f(parcelObtain, rawPeriodInfo, 0);
                    this.mRemote.transact(Stub.TRANSACTION_addCategoryPeriod, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readLong();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
            public long addCategoryPeriodWithAdmin(long j5, RawPeriodInfo rawPeriodInfo, long j6) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDigitalWellbeingInterface.DESCRIPTOR);
                    parcelObtain.writeLong(j5);
                    a.f(parcelObtain, rawPeriodInfo, 0);
                    parcelObtain.writeLong(j6);
                    this.mRemote.transact(Stub.TRANSACTION_addCategoryPeriodWithAdmin, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readLong();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
            public long addGlobalPeriod(RawPeriodInfo rawPeriodInfo) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDigitalWellbeingInterface.DESCRIPTOR);
                    a.f(parcelObtain, rawPeriodInfo, 0);
                    this.mRemote.transact(Stub.TRANSACTION_addGlobalPeriod, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readLong();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
            public long addGlobalPeriodWithAdmin(RawPeriodInfo rawPeriodInfo, long j5) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDigitalWellbeingInterface.DESCRIPTOR);
                    a.f(parcelObtain, rawPeriodInfo, 0);
                    parcelObtain.writeLong(j5);
                    this.mRemote.transact(Stub.TRANSACTION_addGlobalPeriodWithAdmin, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readLong();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
            public long addPackagePeriod(String str, RawPeriodInfo rawPeriodInfo) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDigitalWellbeingInterface.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    a.f(parcelObtain, rawPeriodInfo, 0);
                    this.mRemote.transact(Stub.TRANSACTION_addPackagePeriod, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readLong();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
            public long addPackagePeriodWithAdmin(String str, RawPeriodInfo rawPeriodInfo, long j5) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDigitalWellbeingInterface.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    a.f(parcelObtain, rawPeriodInfo, 0);
                    parcelObtain.writeLong(j5);
                    this.mRemote.transact(Stub.TRANSACTION_addPackagePeriodWithAdmin, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readLong();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
            public long addPeriod(long j5, RawPeriodInfo rawPeriodInfo) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDigitalWellbeingInterface.DESCRIPTOR);
                    parcelObtain.writeLong(j5);
                    a.f(parcelObtain, rawPeriodInfo, 0);
                    this.mRemote.transact(Stub.TRANSACTION_addPeriod, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readLong();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
            public long addPeriodWithAdmin(long j5, RawPeriodInfo rawPeriodInfo, long j6) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDigitalWellbeingInterface.DESCRIPTOR);
                    parcelObtain.writeLong(j5);
                    a.f(parcelObtain, rawPeriodInfo, 0);
                    parcelObtain.writeLong(j6);
                    this.mRemote.transact(Stub.TRANSACTION_addPeriodWithAdmin, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readLong();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
            public void addWhitelistApp(WhitelistAppInfo whitelistAppInfo) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDigitalWellbeingInterface.DESCRIPTOR);
                    a.f(parcelObtain, whitelistAppInfo, 0);
                    this.mRemote.transact(Stub.TRANSACTION_addWhitelistApp, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
            public void clearAdminLimit(long j5) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDigitalWellbeingInterface.DESCRIPTOR);
                    parcelObtain.writeLong(j5);
                    this.mRemote.transact(Stub.TRANSACTION_clearAdminLimit, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
            public Category[] getCategories(boolean z5) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDigitalWellbeingInterface.DESCRIPTOR);
                    parcelObtain.writeInt(z5 ? 1 : 0);
                    this.mRemote.transact(12, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (Category[]) parcelObtain2.createTypedArray(Category.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
            public PeriodLimitInfo[] getCategoriesPeriodLimitInfo(long j5) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDigitalWellbeingInterface.DESCRIPTOR);
                    parcelObtain.writeLong(j5);
                    this.mRemote.transact(36, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (PeriodLimitInfo[]) parcelObtain2.createTypedArray(PeriodLimitInfo.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
            public Category getCategory(boolean z5, int i5) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDigitalWellbeingInterface.DESCRIPTOR);
                    parcelObtain.writeInt(z5 ? 1 : 0);
                    parcelObtain.writeInt(i5);
                    this.mRemote.transact(13, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (Category) a.d(parcelObtain2, Category.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
            public PeriodLimitInfo getCategoryPeriodLimitInfo(long j5, long j6) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDigitalWellbeingInterface.DESCRIPTOR);
                    parcelObtain.writeLong(j5);
                    parcelObtain.writeLong(j6);
                    this.mRemote.transact(34, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (PeriodLimitInfo) a.d(parcelObtain2, PeriodLimitInfo.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
            public RawPeriodInfo[] getCategoryRawPeriod(long j5) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDigitalWellbeingInterface.DESCRIPTOR);
                    parcelObtain.writeLong(j5);
                    this.mRemote.transact(Stub.TRANSACTION_getCategoryRawPeriod, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (RawPeriodInfo[]) parcelObtain2.createTypedArray(RawPeriodInfo.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
            public RawPeriodInfo[] getCategoryRawPeriodWithAdmin(long j5, long j6) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDigitalWellbeingInterface.DESCRIPTOR);
                    parcelObtain.writeLong(j5);
                    parcelObtain.writeLong(j6);
                    this.mRemote.transact(Stub.TRANSACTION_getCategoryRawPeriodWithAdmin, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (RawPeriodInfo[]) parcelObtain2.createTypedArray(RawPeriodInfo.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
            public CategoryUsingTimeStats[] getCategoryUsingTimeStats(int i5, DataToken dataToken) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDigitalWellbeingInterface.DESCRIPTOR);
                    parcelObtain.writeInt(i5);
                    a.f(parcelObtain, dataToken, 0);
                    this.mRemote.transact(10, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    CategoryUsingTimeStats[] categoryUsingTimeStatsArr = (CategoryUsingTimeStats[]) parcelObtain2.createTypedArray(CategoryUsingTimeStats.CREATOR);
                    if (parcelObtain2.readInt() != 0) {
                        dataToken.readFromParcel(parcelObtain2);
                    }
                    return categoryUsingTimeStatsArr;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
            public long getCurrentAdmin() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDigitalWellbeingInterface.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getCurrentAdmin, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readLong();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
            public PeriodLimitInfo getGlobalPeriodLimitInfo(long j5) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDigitalWellbeingInterface.DESCRIPTOR);
                    parcelObtain.writeLong(j5);
                    this.mRemote.transact(37, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (PeriodLimitInfo) a.d(parcelObtain2, PeriodLimitInfo.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
            public RawPeriodInfo[] getGlobalRawPeriod() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDigitalWellbeingInterface.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getGlobalRawPeriod, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (RawPeriodInfo[]) parcelObtain2.createTypedArray(RawPeriodInfo.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
            public RawPeriodInfo[] getGlobalRawPeriodWithAdmin(long j5) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDigitalWellbeingInterface.DESCRIPTOR);
                    parcelObtain.writeLong(j5);
                    this.mRemote.transact(Stub.TRANSACTION_getGlobalRawPeriodWithAdmin, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (RawPeriodInfo[]) parcelObtain2.createTypedArray(RawPeriodInfo.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return IDigitalWellbeingInterface.DESCRIPTOR;
            }

            @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
            public CategoryLimitInfo[] getLimitedCategoriesInfo(boolean z5) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDigitalWellbeingInterface.DESCRIPTOR);
                    parcelObtain.writeInt(z5 ? 1 : 0);
                    this.mRemote.transact(22, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (CategoryLimitInfo[]) parcelObtain2.createTypedArray(CategoryLimitInfo.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
            public CategoryLimitInfo getLimitedCategoryInfo(boolean z5, int i5) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDigitalWellbeingInterface.DESCRIPTOR);
                    parcelObtain.writeInt(z5 ? 1 : 0);
                    parcelObtain.writeInt(i5);
                    this.mRemote.transact(Stub.TRANSACTION_getLimitedCategoryInfo, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (CategoryLimitInfo) a.d(parcelObtain2, CategoryLimitInfo.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
            public GlobalLimitInfo getLimitedGlobalInfo(boolean z5) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDigitalWellbeingInterface.DESCRIPTOR);
                    parcelObtain.writeInt(z5 ? 1 : 0);
                    this.mRemote.transact(25, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (GlobalLimitInfo) a.d(parcelObtain2, GlobalLimitInfo.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
            public PackageLimitInfo getLimitedPackageInfo(boolean z5, String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDigitalWellbeingInterface.DESCRIPTOR);
                    parcelObtain.writeInt(z5 ? 1 : 0);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(23, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (PackageLimitInfo) a.d(parcelObtain2, PackageLimitInfo.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
            public PackageLimitInfo[] getLimitedPackagesInfo(boolean z5) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDigitalWellbeingInterface.DESCRIPTOR);
                    parcelObtain.writeInt(z5 ? 1 : 0);
                    this.mRemote.transact(21, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (PackageLimitInfo[]) parcelObtain2.createTypedArray(PackageLimitInfo.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
            public PackageNotificationTimesStats[] getPackageNotificationTimesStats(int i5, String str, DataToken dataToken) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDigitalWellbeingInterface.DESCRIPTOR);
                    parcelObtain.writeInt(i5);
                    parcelObtain.writeString(str);
                    a.f(parcelObtain, dataToken, 0);
                    this.mRemote.transact(8, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    PackageNotificationTimesStats[] packageNotificationTimesStatsArr = (PackageNotificationTimesStats[]) parcelObtain2.createTypedArray(PackageNotificationTimesStats.CREATOR);
                    if (parcelObtain2.readInt() != 0) {
                        dataToken.readFromParcel(parcelObtain2);
                    }
                    return packageNotificationTimesStatsArr;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
            public PeriodLimitInfo getPackagePeriodLimitInfo(String str, long j5) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDigitalWellbeingInterface.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeLong(j5);
                    this.mRemote.transact(33, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (PeriodLimitInfo) a.d(parcelObtain2, PeriodLimitInfo.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
            public RawPeriodInfo[] getPackageRawPeriod(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDigitalWellbeingInterface.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(Stub.TRANSACTION_getPackageRawPeriod, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (RawPeriodInfo[]) parcelObtain2.createTypedArray(RawPeriodInfo.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
            public RawPeriodInfo[] getPackageRawPeriodWithAdmin(String str, long j5) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDigitalWellbeingInterface.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeLong(j5);
                    this.mRemote.transact(Stub.TRANSACTION_getPackageRawPeriodWithAdmin, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (RawPeriodInfo[]) parcelObtain2.createTypedArray(RawPeriodInfo.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
            public PackageUsingTimeStats[] getPackageUsingTimeStats(int i5, String str, DataToken dataToken) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDigitalWellbeingInterface.DESCRIPTOR);
                    parcelObtain.writeInt(i5);
                    parcelObtain.writeString(str);
                    a.f(parcelObtain, dataToken, 0);
                    this.mRemote.transact(9, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    PackageUsingTimeStats[] packageUsingTimeStatsArr = (PackageUsingTimeStats[]) parcelObtain2.createTypedArray(PackageUsingTimeStats.CREATOR);
                    if (parcelObtain2.readInt() != 0) {
                        dataToken.readFromParcel(parcelObtain2);
                    }
                    return packageUsingTimeStatsArr;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
            public PackageNotificationTimesStats[] getPackagesNotificationTimesStats(int i5, DataToken dataToken) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDigitalWellbeingInterface.DESCRIPTOR);
                    parcelObtain.writeInt(i5);
                    a.f(parcelObtain, dataToken, 0);
                    this.mRemote.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    PackageNotificationTimesStats[] packageNotificationTimesStatsArr = (PackageNotificationTimesStats[]) parcelObtain2.createTypedArray(PackageNotificationTimesStats.CREATOR);
                    if (parcelObtain2.readInt() != 0) {
                        dataToken.readFromParcel(parcelObtain2);
                    }
                    return packageNotificationTimesStatsArr;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
            public PeriodLimitInfo[] getPackagesPeriodLimitInfo(long j5) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDigitalWellbeingInterface.DESCRIPTOR);
                    parcelObtain.writeLong(j5);
                    this.mRemote.transact(35, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (PeriodLimitInfo[]) parcelObtain2.createTypedArray(PeriodLimitInfo.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
            public PackageUsingTimeStats[] getPackagesUsingTimeStats(int i5, DataToken dataToken) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDigitalWellbeingInterface.DESCRIPTOR);
                    parcelObtain.writeInt(i5);
                    a.f(parcelObtain, dataToken, 0);
                    this.mRemote.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    PackageUsingTimeStats[] packageUsingTimeStatsArr = (PackageUsingTimeStats[]) parcelObtain2.createTypedArray(PackageUsingTimeStats.CREATOR);
                    if (parcelObtain2.readInt() != 0) {
                        dataToken.readFromParcel(parcelObtain2);
                    }
                    return packageUsingTimeStatsArr;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
            public NotificationTimesStats[] getPhoneNotificationTimesStats(int i5, DataToken dataToken) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDigitalWellbeingInterface.DESCRIPTOR);
                    parcelObtain.writeInt(i5);
                    a.f(parcelObtain, dataToken, 0);
                    this.mRemote.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    NotificationTimesStats[] notificationTimesStatsArr = (NotificationTimesStats[]) parcelObtain2.createTypedArray(NotificationTimesStats.CREATOR);
                    if (parcelObtain2.readInt() != 0) {
                        dataToken.readFromParcel(parcelObtain2);
                    }
                    return notificationTimesStatsArr;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
            public UsingTimeStats[] getPhoneUsingTimeStats(int i5, DataToken dataToken) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDigitalWellbeingInterface.DESCRIPTOR);
                    parcelObtain.writeInt(i5);
                    a.f(parcelObtain, dataToken, 0);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    UsingTimeStats[] usingTimeStatsArr = (UsingTimeStats[]) parcelObtain2.createTypedArray(UsingTimeStats.CREATOR);
                    if (parcelObtain2.readInt() != 0) {
                        dataToken.readFromParcel(parcelObtain2);
                    }
                    return usingTimeStatsArr;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
            public PickupTimesStats[] getPickupTimesStats(int i5, DataToken dataToken) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDigitalWellbeingInterface.DESCRIPTOR);
                    parcelObtain.writeInt(i5);
                    a.f(parcelObtain, dataToken, 0);
                    this.mRemote.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    PickupTimesStats[] pickupTimesStatsArr = (PickupTimesStats[]) parcelObtain2.createTypedArray(PickupTimesStats.CREATOR);
                    if (parcelObtain2.readInt() != 0) {
                        dataToken.readFromParcel(parcelObtain2);
                    }
                    return pickupTimesStatsArr;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
            public RawPeriodInfo[] getRawPeriod(long j5) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDigitalWellbeingInterface.DESCRIPTOR);
                    parcelObtain.writeLong(j5);
                    this.mRemote.transact(Stub.TRANSACTION_getRawPeriod, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (RawPeriodInfo[]) parcelObtain2.createTypedArray(RawPeriodInfo.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
            public StatsDataSet[] getStatsDataSets(DataToken dataToken) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDigitalWellbeingInterface.DESCRIPTOR);
                    a.f(parcelObtain, dataToken, 0);
                    this.mRemote.transact(11, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    StatsDataSet[] statsDataSetArr = (StatsDataSet[]) parcelObtain2.createTypedArray(StatsDataSet.CREATOR);
                    if (parcelObtain2.readInt() != 0) {
                        dataToken.readFromParcel(parcelObtain2);
                    }
                    return statsDataSetArr;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
            public List<WhitelistAppInfo> getWhitelistAppList() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDigitalWellbeingInterface.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_getWhitelistAppList, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(WhitelistAppInfo.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
            public List<WhitelistAppInfo> getWhitelistAppListWithAdmin(long j5) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDigitalWellbeingInterface.DESCRIPTOR);
                    parcelObtain.writeLong(j5);
                    this.mRemote.transact(Stub.TRANSACTION_getWhitelistAppListWithAdmin, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(WhitelistAppInfo.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
            public void init() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDigitalWellbeingInterface.DESCRIPTOR);
                    this.mRemote.transact(14, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
            public PeriodLimitInfo initCategoryPeriodLimitInfo(long j5, long j6, boolean z5) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDigitalWellbeingInterface.DESCRIPTOR);
                    parcelObtain.writeLong(j5);
                    parcelObtain.writeLong(j6);
                    parcelObtain.writeInt(z5 ? 1 : 0);
                    this.mRemote.transact(30, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (PeriodLimitInfo) a.d(parcelObtain2, PeriodLimitInfo.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
            public PeriodLimitInfo initGlobalPeriodLimitInfo() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDigitalWellbeingInterface.DESCRIPTOR);
                    this.mRemote.transact(32, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (PeriodLimitInfo) a.d(parcelObtain2, PeriodLimitInfo.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
            public PeriodLimitInfo initGlobalPeriodLimitInfoWithAdmin(long j5) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDigitalWellbeingInterface.DESCRIPTOR);
                    parcelObtain.writeLong(j5);
                    this.mRemote.transact(31, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (PeriodLimitInfo) a.d(parcelObtain2, PeriodLimitInfo.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
            public PeriodLimitInfo initPackagePeriodLimitInfo(String str, long j5, boolean z5) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDigitalWellbeingInterface.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeLong(j5);
                    parcelObtain.writeInt(z5 ? 1 : 0);
                    this.mRemote.transact(Stub.TRANSACTION_initPackagePeriodLimitInfo, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (PeriodLimitInfo) a.d(parcelObtain2, PeriodLimitInfo.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
            public boolean isEnable() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDigitalWellbeingInterface.DESCRIPTOR);
                    this.mRemote.transact(Stub.TRANSACTION_isEnable, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
            public boolean isPackageLimitable(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDigitalWellbeingInterface.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(26, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
            public DataToken queryUsageData(int i5, boolean z5) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDigitalWellbeingInterface.DESCRIPTOR);
                    parcelObtain.writeInt(i5);
                    parcelObtain.writeInt(z5 ? 1 : 0);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (DataToken) a.d(parcelObtain2, DataToken.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
            public DataToken queryUsageDataSet(int i5, boolean z5) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDigitalWellbeingInterface.DESCRIPTOR);
                    parcelObtain.writeInt(i5);
                    parcelObtain.writeInt(z5 ? 1 : 0);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (DataToken) a.d(parcelObtain2, DataToken.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
            public long removeCategoryPeriod(long j5, long j6) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDigitalWellbeingInterface.DESCRIPTOR);
                    parcelObtain.writeLong(j5);
                    parcelObtain.writeLong(j6);
                    this.mRemote.transact(Stub.TRANSACTION_removeCategoryPeriod, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readLong();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
            public long removeCategoryPeriodWithAdmin(long j5, long j6, long j7) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDigitalWellbeingInterface.DESCRIPTOR);
                    parcelObtain.writeLong(j5);
                    parcelObtain.writeLong(j6);
                    parcelObtain.writeLong(j7);
                    this.mRemote.transact(Stub.TRANSACTION_removeCategoryPeriodWithAdmin, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readLong();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
            public long removeGlobalPeriod(long j5) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDigitalWellbeingInterface.DESCRIPTOR);
                    parcelObtain.writeLong(j5);
                    this.mRemote.transact(Stub.TRANSACTION_removeGlobalPeriod, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readLong();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
            public long removeGlobalPeriodWithAdmin(long j5, long j6) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDigitalWellbeingInterface.DESCRIPTOR);
                    parcelObtain.writeLong(j5);
                    parcelObtain.writeLong(j6);
                    this.mRemote.transact(Stub.TRANSACTION_removeGlobalPeriodWithAdmin, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readLong();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
            public long removePackagePeriod(String str, long j5) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDigitalWellbeingInterface.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeLong(j5);
                    this.mRemote.transact(Stub.TRANSACTION_removePackagePeriod, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readLong();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
            public long removePackagePeriodWithAdmin(String str, long j5, long j6) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDigitalWellbeingInterface.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeLong(j5);
                    parcelObtain.writeLong(j6);
                    this.mRemote.transact(Stub.TRANSACTION_removePackagePeriodWithAdmin, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readLong();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
            public long removePeriod(long j5, long j6) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDigitalWellbeingInterface.DESCRIPTOR);
                    parcelObtain.writeLong(j5);
                    parcelObtain.writeLong(j6);
                    this.mRemote.transact(Stub.TRANSACTION_removePeriod, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readLong();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
            public long removePeriodWithAdmin(long j5, long j6, long j7) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDigitalWellbeingInterface.DESCRIPTOR);
                    parcelObtain.writeLong(j5);
                    parcelObtain.writeLong(j6);
                    parcelObtain.writeLong(j7);
                    this.mRemote.transact(Stub.TRANSACTION_removePeriodWithAdmin, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readLong();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
            public void removeWhitelistApp(WhitelistAppInfo whitelistAppInfo) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDigitalWellbeingInterface.DESCRIPTOR);
                    a.f(parcelObtain, whitelistAppInfo, 0);
                    this.mRemote.transact(Stub.TRANSACTION_removeWhitelistApp, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
            public boolean setCategoryLimitTime(int i5, int i6, long j5, long j6, boolean z5, boolean z6) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDigitalWellbeingInterface.DESCRIPTOR);
                    parcelObtain.writeInt(i5);
                    parcelObtain.writeInt(i6);
                    parcelObtain.writeLong(j5);
                    parcelObtain.writeLong(j6);
                    parcelObtain.writeInt(z5 ? 1 : 0);
                    parcelObtain.writeInt(z6 ? 1 : 0);
                    this.mRemote.transact(16, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
            public boolean setCategoryLimitTimeWithAdmin(int i5, int i6, long j5, long j6, boolean z5, boolean z6, long j7, boolean z7) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDigitalWellbeingInterface.DESCRIPTOR);
                    parcelObtain.writeInt(i5);
                    parcelObtain.writeInt(i6);
                    parcelObtain.writeLong(j5);
                    parcelObtain.writeLong(j6);
                    parcelObtain.writeInt(z5 ? 1 : 0);
                    parcelObtain.writeInt(z6 ? 1 : 0);
                    parcelObtain.writeLong(j7);
                    parcelObtain.writeInt(z7 ? 1 : 0);
                    this.mRemote.transact(19, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
            public PeriodLimitInfo setCategoryPeriodLimit(long j5, boolean z5, boolean z6) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDigitalWellbeingInterface.DESCRIPTOR);
                    parcelObtain.writeLong(j5);
                    parcelObtain.writeInt(z5 ? 1 : 0);
                    parcelObtain.writeInt(z6 ? 1 : 0);
                    this.mRemote.transact(39, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (PeriodLimitInfo) a.d(parcelObtain2, PeriodLimitInfo.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
            public PeriodLimitInfo setCategoryPeriodLimitWithAdmin(long j5, boolean z5, boolean z6, long j6, boolean z7) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDigitalWellbeingInterface.DESCRIPTOR);
                    parcelObtain.writeLong(j5);
                    parcelObtain.writeInt(z5 ? 1 : 0);
                    parcelObtain.writeInt(z6 ? 1 : 0);
                    parcelObtain.writeLong(j6);
                    parcelObtain.writeInt(z7 ? 1 : 0);
                    this.mRemote.transact(42, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (PeriodLimitInfo) a.d(parcelObtain2, PeriodLimitInfo.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
            public void setCurrentAdmin(long j5) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDigitalWellbeingInterface.DESCRIPTOR);
                    parcelObtain.writeLong(j5);
                    this.mRemote.transact(27, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
            public void setEnable(boolean z5) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDigitalWellbeingInterface.DESCRIPTOR);
                    parcelObtain.writeInt(z5 ? 1 : 0);
                    this.mRemote.transact(Stub.TRANSACTION_setEnable, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
            public boolean setGlobalLimitTime(int i5, long j5, long j6, boolean z5, boolean z6) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDigitalWellbeingInterface.DESCRIPTOR);
                    parcelObtain.writeInt(i5);
                    parcelObtain.writeLong(j5);
                    parcelObtain.writeLong(j6);
                    parcelObtain.writeInt(z5 ? 1 : 0);
                    parcelObtain.writeInt(z6 ? 1 : 0);
                    this.mRemote.transact(17, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
            public boolean setGlobalLimitTimeWithAdmin(int i5, long j5, long j6, boolean z5, boolean z6, long j7, boolean z7) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDigitalWellbeingInterface.DESCRIPTOR);
                    parcelObtain.writeInt(i5);
                    parcelObtain.writeLong(j5);
                    parcelObtain.writeLong(j6);
                    parcelObtain.writeInt(z5 ? 1 : 0);
                    parcelObtain.writeInt(z6 ? 1 : 0);
                    parcelObtain.writeLong(j7);
                    parcelObtain.writeInt(z7 ? 1 : 0);
                    this.mRemote.transact(20, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
            public PeriodLimitInfo setGlobalPeriodLimit(boolean z5, boolean z6) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDigitalWellbeingInterface.DESCRIPTOR);
                    parcelObtain.writeInt(z5 ? 1 : 0);
                    parcelObtain.writeInt(z6 ? 1 : 0);
                    this.mRemote.transact(40, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (PeriodLimitInfo) a.d(parcelObtain2, PeriodLimitInfo.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
            public PeriodLimitInfo setGlobalPeriodLimitWithAdmin(boolean z5, boolean z6, long j5) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDigitalWellbeingInterface.DESCRIPTOR);
                    parcelObtain.writeInt(z5 ? 1 : 0);
                    parcelObtain.writeInt(z6 ? 1 : 0);
                    parcelObtain.writeLong(j5);
                    this.mRemote.transact(Stub.TRANSACTION_setGlobalPeriodLimitWithAdmin, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (PeriodLimitInfo) a.d(parcelObtain2, PeriodLimitInfo.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
            public boolean setPackageLimitTime(int i5, String str, long j5, long j6, boolean z5, boolean z6) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDigitalWellbeingInterface.DESCRIPTOR);
                    parcelObtain.writeInt(i5);
                    parcelObtain.writeString(str);
                    parcelObtain.writeLong(j5);
                    parcelObtain.writeLong(j6);
                    parcelObtain.writeInt(z5 ? 1 : 0);
                    parcelObtain.writeInt(z6 ? 1 : 0);
                    this.mRemote.transact(Stub.TRANSACTION_setPackageLimitTime, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
            public boolean setPackageLimitTimeWithAdmin(int i5, String str, long j5, long j6, boolean z5, boolean z6, long j7, boolean z7) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDigitalWellbeingInterface.DESCRIPTOR);
                    parcelObtain.writeInt(i5);
                    parcelObtain.writeString(str);
                    parcelObtain.writeLong(j5);
                    parcelObtain.writeLong(j6);
                    parcelObtain.writeInt(z5 ? 1 : 0);
                    parcelObtain.writeInt(z6 ? 1 : 0);
                    parcelObtain.writeLong(j7);
                    parcelObtain.writeInt(z7 ? 1 : 0);
                    this.mRemote.transact(18, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
            public PeriodLimitInfo setPackagePeriodLimit(String str, boolean z5, boolean z6) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDigitalWellbeingInterface.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(z5 ? 1 : 0);
                    parcelObtain.writeInt(z6 ? 1 : 0);
                    this.mRemote.transact(38, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (PeriodLimitInfo) a.d(parcelObtain2, PeriodLimitInfo.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
            public PeriodLimitInfo setPackagePeriodLimitWithAdmin(String str, boolean z5, boolean z6, long j5, boolean z7) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDigitalWellbeingInterface.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(z5 ? 1 : 0);
                    parcelObtain.writeInt(z6 ? 1 : 0);
                    parcelObtain.writeLong(j5);
                    parcelObtain.writeInt(z7 ? 1 : 0);
                    this.mRemote.transact(41, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (PeriodLimitInfo) a.d(parcelObtain2, PeriodLimitInfo.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
            public long updateCategoryPeriod(long j5, RawPeriodInfo rawPeriodInfo) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDigitalWellbeingInterface.DESCRIPTOR);
                    parcelObtain.writeLong(j5);
                    a.f(parcelObtain, rawPeriodInfo, 0);
                    this.mRemote.transact(Stub.TRANSACTION_updateCategoryPeriod, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readLong();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
            public long updateCategoryPeriodWithAdmin(long j5, RawPeriodInfo rawPeriodInfo, long j6) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDigitalWellbeingInterface.DESCRIPTOR);
                    parcelObtain.writeLong(j5);
                    a.f(parcelObtain, rawPeriodInfo, 0);
                    parcelObtain.writeLong(j6);
                    this.mRemote.transact(Stub.TRANSACTION_updateCategoryPeriodWithAdmin, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readLong();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
            public long updateGlobalPeriod(RawPeriodInfo rawPeriodInfo) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDigitalWellbeingInterface.DESCRIPTOR);
                    a.f(parcelObtain, rawPeriodInfo, 0);
                    this.mRemote.transact(Stub.TRANSACTION_updateGlobalPeriod, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readLong();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
            public long updateGlobalPeriodWithAdmin(RawPeriodInfo rawPeriodInfo, long j5) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDigitalWellbeingInterface.DESCRIPTOR);
                    a.f(parcelObtain, rawPeriodInfo, 0);
                    parcelObtain.writeLong(j5);
                    this.mRemote.transact(Stub.TRANSACTION_updateGlobalPeriodWithAdmin, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readLong();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
            public long updatePackagePeriod(String str, RawPeriodInfo rawPeriodInfo) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDigitalWellbeingInterface.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    a.f(parcelObtain, rawPeriodInfo, 0);
                    this.mRemote.transact(Stub.TRANSACTION_updatePackagePeriod, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readLong();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
            public long updatePackagePeriodWithAdmin(String str, RawPeriodInfo rawPeriodInfo, long j5) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDigitalWellbeingInterface.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    a.f(parcelObtain, rawPeriodInfo, 0);
                    parcelObtain.writeLong(j5);
                    this.mRemote.transact(Stub.TRANSACTION_updatePackagePeriodWithAdmin, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readLong();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
            public long updatePeriod(long j5, RawPeriodInfo rawPeriodInfo) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDigitalWellbeingInterface.DESCRIPTOR);
                    parcelObtain.writeLong(j5);
                    a.f(parcelObtain, rawPeriodInfo, 0);
                    this.mRemote.transact(Stub.TRANSACTION_updatePeriod, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readLong();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface
            public long updatePeriodWithAdmin(long j5, RawPeriodInfo rawPeriodInfo, long j6) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IDigitalWellbeingInterface.DESCRIPTOR);
                    parcelObtain.writeLong(j5);
                    a.f(parcelObtain, rawPeriodInfo, 0);
                    parcelObtain.writeLong(j6);
                    this.mRemote.transact(Stub.TRANSACTION_updatePeriodWithAdmin, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readLong();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IDigitalWellbeingInterface.DESCRIPTOR);
        }

        public static IDigitalWellbeingInterface asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IDigitalWellbeingInterface.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IDigitalWellbeingInterface)) ? new Proxy(iBinder) : (IDigitalWellbeingInterface) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i5, Parcel parcel, Parcel parcel2, int i6) {
            boolean z5;
            boolean z6;
            boolean z7;
            long j5;
            boolean z8;
            boolean z9;
            boolean z10;
            long j6;
            if (i5 >= 1 && i5 <= 16777215) {
                parcel.enforceInterface(IDigitalWellbeingInterface.DESCRIPTOR);
            }
            if (i5 == 1598968902) {
                parcel2.writeString(IDigitalWellbeingInterface.DESCRIPTOR);
                return true;
            }
            switch (i5) {
                case 1:
                    DataToken dataTokenQueryUsageDataSet = queryUsageDataSet(parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    a.f(parcel2, dataTokenQueryUsageDataSet, 1);
                    return true;
                case 2:
                    DataToken dataTokenQueryUsageData = queryUsageData(parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    a.f(parcel2, dataTokenQueryUsageData, 1);
                    return true;
                case 3:
                    int i7 = parcel.readInt();
                    DataToken dataToken = (DataToken) a.d(parcel, DataToken.CREATOR);
                    UsingTimeStats[] phoneUsingTimeStats = getPhoneUsingTimeStats(i7, dataToken);
                    parcel2.writeNoException();
                    parcel2.writeTypedArray(phoneUsingTimeStats, 1);
                    a.f(parcel2, dataToken, 1);
                    return true;
                case 4:
                    int i8 = parcel.readInt();
                    DataToken dataToken2 = (DataToken) a.d(parcel, DataToken.CREATOR);
                    NotificationTimesStats[] phoneNotificationTimesStats = getPhoneNotificationTimesStats(i8, dataToken2);
                    parcel2.writeNoException();
                    parcel2.writeTypedArray(phoneNotificationTimesStats, 1);
                    a.f(parcel2, dataToken2, 1);
                    return true;
                case 5:
                    int i9 = parcel.readInt();
                    DataToken dataToken3 = (DataToken) a.d(parcel, DataToken.CREATOR);
                    PickupTimesStats[] pickupTimesStats = getPickupTimesStats(i9, dataToken3);
                    parcel2.writeNoException();
                    parcel2.writeTypedArray(pickupTimesStats, 1);
                    a.f(parcel2, dataToken3, 1);
                    return true;
                case 6:
                    int i10 = parcel.readInt();
                    DataToken dataToken4 = (DataToken) a.d(parcel, DataToken.CREATOR);
                    PackageUsingTimeStats[] packagesUsingTimeStats = getPackagesUsingTimeStats(i10, dataToken4);
                    parcel2.writeNoException();
                    parcel2.writeTypedArray(packagesUsingTimeStats, 1);
                    a.f(parcel2, dataToken4, 1);
                    return true;
                case 7:
                    int i11 = parcel.readInt();
                    DataToken dataToken5 = (DataToken) a.d(parcel, DataToken.CREATOR);
                    PackageNotificationTimesStats[] packagesNotificationTimesStats = getPackagesNotificationTimesStats(i11, dataToken5);
                    parcel2.writeNoException();
                    parcel2.writeTypedArray(packagesNotificationTimesStats, 1);
                    a.f(parcel2, dataToken5, 1);
                    return true;
                case 8:
                    int i12 = parcel.readInt();
                    String string = parcel.readString();
                    DataToken dataToken6 = (DataToken) a.d(parcel, DataToken.CREATOR);
                    PackageNotificationTimesStats[] packageNotificationTimesStats = getPackageNotificationTimesStats(i12, string, dataToken6);
                    parcel2.writeNoException();
                    parcel2.writeTypedArray(packageNotificationTimesStats, 1);
                    a.f(parcel2, dataToken6, 1);
                    return true;
                case 9:
                    int i13 = parcel.readInt();
                    String string2 = parcel.readString();
                    DataToken dataToken7 = (DataToken) a.d(parcel, DataToken.CREATOR);
                    PackageUsingTimeStats[] packageUsingTimeStats = getPackageUsingTimeStats(i13, string2, dataToken7);
                    parcel2.writeNoException();
                    parcel2.writeTypedArray(packageUsingTimeStats, 1);
                    a.f(parcel2, dataToken7, 1);
                    return true;
                case 10:
                    int i14 = parcel.readInt();
                    DataToken dataToken8 = (DataToken) a.d(parcel, DataToken.CREATOR);
                    CategoryUsingTimeStats[] categoryUsingTimeStats = getCategoryUsingTimeStats(i14, dataToken8);
                    parcel2.writeNoException();
                    parcel2.writeTypedArray(categoryUsingTimeStats, 1);
                    a.f(parcel2, dataToken8, 1);
                    return true;
                case 11:
                    DataToken dataToken9 = (DataToken) a.d(parcel, DataToken.CREATOR);
                    StatsDataSet[] statsDataSets = getStatsDataSets(dataToken9);
                    parcel2.writeNoException();
                    parcel2.writeTypedArray(statsDataSets, 1);
                    a.f(parcel2, dataToken9, 1);
                    return true;
                case 12:
                    Category[] categories = getCategories(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    parcel2.writeTypedArray(categories, 1);
                    return true;
                case 13:
                    Category category = getCategory(parcel.readInt() != 0, parcel.readInt());
                    parcel2.writeNoException();
                    a.f(parcel2, category, 1);
                    return true;
                case 14:
                    init();
                    parcel2.writeNoException();
                    return true;
                case TRANSACTION_setPackageLimitTime /* 15 */:
                    boolean packageLimitTime = setPackageLimitTime(parcel.readInt(), parcel.readString(), parcel.readLong(), parcel.readLong(), parcel.readInt() != 0, parcel.readInt() != 0);
                    parcel2.writeNoException();
                    parcel2.writeInt(packageLimitTime ? 1 : 0);
                    return true;
                case 16:
                    boolean categoryLimitTime = setCategoryLimitTime(parcel.readInt(), parcel.readInt(), parcel.readLong(), parcel.readLong(), parcel.readInt() != 0, parcel.readInt() != 0);
                    parcel2.writeNoException();
                    parcel2.writeInt(categoryLimitTime ? 1 : 0);
                    return true;
                case 17:
                    boolean globalLimitTime = setGlobalLimitTime(parcel.readInt(), parcel.readLong(), parcel.readLong(), parcel.readInt() != 0, parcel.readInt() != 0);
                    parcel2.writeNoException();
                    parcel2.writeInt(globalLimitTime ? 1 : 0);
                    return true;
                case 18:
                    boolean packageLimitTimeWithAdmin = setPackageLimitTimeWithAdmin(parcel.readInt(), parcel.readString(), parcel.readLong(), parcel.readLong(), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readLong(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    parcel2.writeInt(packageLimitTimeWithAdmin ? 1 : 0);
                    return true;
                case 19:
                    boolean z11 = false;
                    int i15 = parcel.readInt();
                    int i16 = parcel.readInt();
                    long j7 = parcel.readLong();
                    long j8 = parcel.readLong();
                    boolean z12 = parcel.readInt() != 0;
                    if (parcel.readInt() != 0) {
                        z5 = false;
                        z11 = true;
                    } else {
                        z5 = false;
                    }
                    boolean categoryLimitTimeWithAdmin = setCategoryLimitTimeWithAdmin(i15, i16, j7, j8, z12, z11, parcel.readLong(), parcel.readInt() != 0 ? true : z5);
                    parcel2.writeNoException();
                    parcel2.writeInt(categoryLimitTimeWithAdmin ? 1 : 0);
                    return true;
                case 20:
                    boolean z13 = false;
                    int i17 = parcel.readInt();
                    long j9 = parcel.readLong();
                    long j10 = parcel.readLong();
                    if (parcel.readInt() != 0) {
                        z6 = false;
                        z13 = true;
                    } else {
                        z6 = false;
                    }
                    boolean z14 = parcel.readInt() != 0 ? true : z6;
                    long j11 = parcel.readLong();
                    if (parcel.readInt() != 0) {
                        j5 = j11;
                        z7 = true;
                    } else {
                        z7 = z6;
                        j5 = j11;
                    }
                    boolean globalLimitTimeWithAdmin = setGlobalLimitTimeWithAdmin(i17, j9, j10, z13, z14, j5, z7);
                    parcel2.writeNoException();
                    parcel2.writeInt(globalLimitTimeWithAdmin ? 1 : 0);
                    return true;
                case 21:
                    PackageLimitInfo[] limitedPackagesInfo = getLimitedPackagesInfo(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    parcel2.writeTypedArray(limitedPackagesInfo, 1);
                    return true;
                case 22:
                    CategoryLimitInfo[] limitedCategoriesInfo = getLimitedCategoriesInfo(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    parcel2.writeTypedArray(limitedCategoriesInfo, 1);
                    return true;
                case 23:
                    PackageLimitInfo limitedPackageInfo = getLimitedPackageInfo(parcel.readInt() != 0, parcel.readString());
                    parcel2.writeNoException();
                    a.f(parcel2, limitedPackageInfo, 1);
                    return true;
                case TRANSACTION_getLimitedCategoryInfo /* 24 */:
                    CategoryLimitInfo limitedCategoryInfo = getLimitedCategoryInfo(parcel.readInt() != 0, parcel.readInt());
                    parcel2.writeNoException();
                    a.f(parcel2, limitedCategoryInfo, 1);
                    return true;
                case 25:
                    GlobalLimitInfo limitedGlobalInfo = getLimitedGlobalInfo(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    a.f(parcel2, limitedGlobalInfo, 1);
                    return true;
                case 26:
                    boolean zIsPackageLimitable = isPackageLimitable(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(zIsPackageLimitable ? 1 : 0);
                    return true;
                case 27:
                    setCurrentAdmin(parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case TRANSACTION_getCurrentAdmin /* 28 */:
                    long currentAdmin = getCurrentAdmin();
                    parcel2.writeNoException();
                    parcel2.writeLong(currentAdmin);
                    return true;
                case TRANSACTION_initPackagePeriodLimitInfo /* 29 */:
                    boolean z15 = false;
                    String string3 = parcel.readString();
                    long j12 = parcel.readLong();
                    if (parcel.readInt() != 0) {
                        z15 = true;
                    }
                    PeriodLimitInfo periodLimitInfoInitPackagePeriodLimitInfo = initPackagePeriodLimitInfo(string3, j12, z15);
                    parcel2.writeNoException();
                    a.f(parcel2, periodLimitInfoInitPackagePeriodLimitInfo, 1);
                    return true;
                case 30:
                    PeriodLimitInfo periodLimitInfoInitCategoryPeriodLimitInfo = initCategoryPeriodLimitInfo(parcel.readLong(), parcel.readLong(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    a.f(parcel2, periodLimitInfoInitCategoryPeriodLimitInfo, 1);
                    return true;
                case 31:
                    PeriodLimitInfo periodLimitInfoInitGlobalPeriodLimitInfoWithAdmin = initGlobalPeriodLimitInfoWithAdmin(parcel.readLong());
                    parcel2.writeNoException();
                    a.f(parcel2, periodLimitInfoInitGlobalPeriodLimitInfoWithAdmin, 1);
                    return true;
                case 32:
                    PeriodLimitInfo periodLimitInfoInitGlobalPeriodLimitInfo = initGlobalPeriodLimitInfo();
                    parcel2.writeNoException();
                    a.f(parcel2, periodLimitInfoInitGlobalPeriodLimitInfo, 1);
                    return true;
                case 33:
                    PeriodLimitInfo packagePeriodLimitInfo = getPackagePeriodLimitInfo(parcel.readString(), parcel.readLong());
                    parcel2.writeNoException();
                    a.f(parcel2, packagePeriodLimitInfo, 1);
                    return true;
                case 34:
                    PeriodLimitInfo categoryPeriodLimitInfo = getCategoryPeriodLimitInfo(parcel.readLong(), parcel.readLong());
                    parcel2.writeNoException();
                    a.f(parcel2, categoryPeriodLimitInfo, 1);
                    return true;
                case 35:
                    PeriodLimitInfo[] packagesPeriodLimitInfo = getPackagesPeriodLimitInfo(parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeTypedArray(packagesPeriodLimitInfo, 1);
                    return true;
                case 36:
                    PeriodLimitInfo[] categoriesPeriodLimitInfo = getCategoriesPeriodLimitInfo(parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeTypedArray(categoriesPeriodLimitInfo, 1);
                    return true;
                case 37:
                    PeriodLimitInfo globalPeriodLimitInfo = getGlobalPeriodLimitInfo(parcel.readLong());
                    parcel2.writeNoException();
                    a.f(parcel2, globalPeriodLimitInfo, 1);
                    return true;
                case 38:
                    boolean z16 = false;
                    String string4 = parcel.readString();
                    boolean z17 = parcel.readInt() != 0;
                    if (parcel.readInt() != 0) {
                        z16 = true;
                    }
                    PeriodLimitInfo packagePeriodLimit = setPackagePeriodLimit(string4, z17, z16);
                    parcel2.writeNoException();
                    a.f(parcel2, packagePeriodLimit, 1);
                    return true;
                case 39:
                    boolean z18 = false;
                    long j13 = parcel.readLong();
                    boolean z19 = parcel.readInt() != 0;
                    if (parcel.readInt() != 0) {
                        z18 = true;
                    }
                    PeriodLimitInfo categoryPeriodLimit = setCategoryPeriodLimit(j13, z19, z18);
                    parcel2.writeNoException();
                    a.f(parcel2, categoryPeriodLimit, 1);
                    return true;
                case 40:
                    PeriodLimitInfo globalPeriodLimit = setGlobalPeriodLimit(parcel.readInt() != 0, parcel.readInt() != 0);
                    parcel2.writeNoException();
                    a.f(parcel2, globalPeriodLimit, 1);
                    return true;
                case 41:
                    boolean z20 = false;
                    String string5 = parcel.readString();
                    boolean z21 = parcel.readInt() != 0;
                    boolean z22 = parcel.readInt() != 0;
                    long j14 = parcel.readLong();
                    if (parcel.readInt() != 0) {
                        z20 = true;
                    }
                    PeriodLimitInfo packagePeriodLimitWithAdmin = setPackagePeriodLimitWithAdmin(string5, z21, z22, j14, z20);
                    parcel2.writeNoException();
                    a.f(parcel2, packagePeriodLimitWithAdmin, 1);
                    return true;
                case 42:
                    long j15 = parcel.readLong();
                    if (parcel.readInt() != 0) {
                        z8 = false;
                        z = true;
                    } else {
                        z8 = false;
                    }
                    if (parcel.readInt() != 0) {
                        z9 = z8;
                        z8 = true;
                    } else {
                        z9 = z8;
                    }
                    long j16 = parcel.readLong();
                    if (parcel.readInt() != 0) {
                        j6 = j16;
                        z10 = true;
                    } else {
                        z10 = z9;
                        j6 = j16;
                    }
                    PeriodLimitInfo categoryPeriodLimitWithAdmin = setCategoryPeriodLimitWithAdmin(j15, z, z8, j6, z10);
                    parcel2.writeNoException();
                    a.f(parcel2, categoryPeriodLimitWithAdmin, 1);
                    return true;
                case TRANSACTION_setGlobalPeriodLimitWithAdmin /* 43 */:
                    PeriodLimitInfo globalPeriodLimitWithAdmin = setGlobalPeriodLimitWithAdmin(parcel.readInt() != 0, parcel.readInt() != 0, parcel.readLong());
                    parcel2.writeNoException();
                    a.f(parcel2, globalPeriodLimitWithAdmin, 1);
                    return true;
                case TRANSACTION_getRawPeriod /* 44 */:
                    RawPeriodInfo[] rawPeriod = getRawPeriod(parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeTypedArray(rawPeriod, 1);
                    return true;
                case TRANSACTION_getPackageRawPeriodWithAdmin /* 45 */:
                    RawPeriodInfo[] packageRawPeriodWithAdmin = getPackageRawPeriodWithAdmin(parcel.readString(), parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeTypedArray(packageRawPeriodWithAdmin, 1);
                    return true;
                case TRANSACTION_getPackageRawPeriod /* 46 */:
                    RawPeriodInfo[] packageRawPeriod = getPackageRawPeriod(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeTypedArray(packageRawPeriod, 1);
                    return true;
                case TRANSACTION_getCategoryRawPeriodWithAdmin /* 47 */:
                    RawPeriodInfo[] categoryRawPeriodWithAdmin = getCategoryRawPeriodWithAdmin(parcel.readLong(), parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeTypedArray(categoryRawPeriodWithAdmin, 1);
                    return true;
                case TRANSACTION_getCategoryRawPeriod /* 48 */:
                    RawPeriodInfo[] categoryRawPeriod = getCategoryRawPeriod(parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeTypedArray(categoryRawPeriod, 1);
                    return true;
                case TRANSACTION_getGlobalRawPeriodWithAdmin /* 49 */:
                    RawPeriodInfo[] globalRawPeriodWithAdmin = getGlobalRawPeriodWithAdmin(parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeTypedArray(globalRawPeriodWithAdmin, 1);
                    return true;
                case TRANSACTION_getGlobalRawPeriod /* 50 */:
                    RawPeriodInfo[] globalRawPeriod = getGlobalRawPeriod();
                    parcel2.writeNoException();
                    parcel2.writeTypedArray(globalRawPeriod, 1);
                    return true;
                case TRANSACTION_addPeriod /* 51 */:
                    long jAddPeriod = addPeriod(parcel.readLong(), (RawPeriodInfo) a.d(parcel, RawPeriodInfo.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeLong(jAddPeriod);
                    return true;
                case TRANSACTION_addPeriodWithAdmin /* 52 */:
                    long jAddPeriodWithAdmin = addPeriodWithAdmin(parcel.readLong(), (RawPeriodInfo) a.d(parcel, RawPeriodInfo.CREATOR), parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeLong(jAddPeriodWithAdmin);
                    return true;
                case TRANSACTION_addPackagePeriod /* 53 */:
                    long jAddPackagePeriod = addPackagePeriod(parcel.readString(), (RawPeriodInfo) a.d(parcel, RawPeriodInfo.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeLong(jAddPackagePeriod);
                    return true;
                case TRANSACTION_addPackagePeriodWithAdmin /* 54 */:
                    long jAddPackagePeriodWithAdmin = addPackagePeriodWithAdmin(parcel.readString(), (RawPeriodInfo) a.d(parcel, RawPeriodInfo.CREATOR), parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeLong(jAddPackagePeriodWithAdmin);
                    return true;
                case TRANSACTION_addCategoryPeriod /* 55 */:
                    long jAddCategoryPeriod = addCategoryPeriod(parcel.readLong(), (RawPeriodInfo) a.d(parcel, RawPeriodInfo.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeLong(jAddCategoryPeriod);
                    return true;
                case TRANSACTION_addCategoryPeriodWithAdmin /* 56 */:
                    long jAddCategoryPeriodWithAdmin = addCategoryPeriodWithAdmin(parcel.readLong(), (RawPeriodInfo) a.d(parcel, RawPeriodInfo.CREATOR), parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeLong(jAddCategoryPeriodWithAdmin);
                    return true;
                case TRANSACTION_addGlobalPeriod /* 57 */:
                    long jAddGlobalPeriod = addGlobalPeriod((RawPeriodInfo) a.d(parcel, RawPeriodInfo.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeLong(jAddGlobalPeriod);
                    return true;
                case TRANSACTION_addGlobalPeriodWithAdmin /* 58 */:
                    long jAddGlobalPeriodWithAdmin = addGlobalPeriodWithAdmin((RawPeriodInfo) a.d(parcel, RawPeriodInfo.CREATOR), parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeLong(jAddGlobalPeriodWithAdmin);
                    return true;
                case TRANSACTION_removePeriod /* 59 */:
                    long jRemovePeriod = removePeriod(parcel.readLong(), parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeLong(jRemovePeriod);
                    return true;
                case TRANSACTION_removePeriodWithAdmin /* 60 */:
                    long jRemovePeriodWithAdmin = removePeriodWithAdmin(parcel.readLong(), parcel.readLong(), parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeLong(jRemovePeriodWithAdmin);
                    return true;
                case TRANSACTION_removePackagePeriod /* 61 */:
                    long jRemovePackagePeriod = removePackagePeriod(parcel.readString(), parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeLong(jRemovePackagePeriod);
                    return true;
                case TRANSACTION_removePackagePeriodWithAdmin /* 62 */:
                    long jRemovePackagePeriodWithAdmin = removePackagePeriodWithAdmin(parcel.readString(), parcel.readLong(), parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeLong(jRemovePackagePeriodWithAdmin);
                    return true;
                case TRANSACTION_removeCategoryPeriod /* 63 */:
                    long jRemoveCategoryPeriod = removeCategoryPeriod(parcel.readLong(), parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeLong(jRemoveCategoryPeriod);
                    return true;
                case TRANSACTION_removeCategoryPeriodWithAdmin /* 64 */:
                    long jRemoveCategoryPeriodWithAdmin = removeCategoryPeriodWithAdmin(parcel.readLong(), parcel.readLong(), parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeLong(jRemoveCategoryPeriodWithAdmin);
                    return true;
                case TRANSACTION_removeGlobalPeriod /* 65 */:
                    long jRemoveGlobalPeriod = removeGlobalPeriod(parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeLong(jRemoveGlobalPeriod);
                    return true;
                case TRANSACTION_removeGlobalPeriodWithAdmin /* 66 */:
                    long jRemoveGlobalPeriodWithAdmin = removeGlobalPeriodWithAdmin(parcel.readLong(), parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeLong(jRemoveGlobalPeriodWithAdmin);
                    return true;
                case TRANSACTION_updatePeriod /* 67 */:
                    long jUpdatePeriod = updatePeriod(parcel.readLong(), (RawPeriodInfo) a.d(parcel, RawPeriodInfo.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeLong(jUpdatePeriod);
                    return true;
                case TRANSACTION_updatePeriodWithAdmin /* 68 */:
                    long jUpdatePeriodWithAdmin = updatePeriodWithAdmin(parcel.readLong(), (RawPeriodInfo) a.d(parcel, RawPeriodInfo.CREATOR), parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeLong(jUpdatePeriodWithAdmin);
                    return true;
                case TRANSACTION_updatePackagePeriod /* 69 */:
                    long jUpdatePackagePeriod = updatePackagePeriod(parcel.readString(), (RawPeriodInfo) a.d(parcel, RawPeriodInfo.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeLong(jUpdatePackagePeriod);
                    return true;
                case TRANSACTION_updatePackagePeriodWithAdmin /* 70 */:
                    long jUpdatePackagePeriodWithAdmin = updatePackagePeriodWithAdmin(parcel.readString(), (RawPeriodInfo) a.d(parcel, RawPeriodInfo.CREATOR), parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeLong(jUpdatePackagePeriodWithAdmin);
                    return true;
                case TRANSACTION_updateCategoryPeriod /* 71 */:
                    long jUpdateCategoryPeriod = updateCategoryPeriod(parcel.readLong(), (RawPeriodInfo) a.d(parcel, RawPeriodInfo.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeLong(jUpdateCategoryPeriod);
                    return true;
                case TRANSACTION_updateCategoryPeriodWithAdmin /* 72 */:
                    long jUpdateCategoryPeriodWithAdmin = updateCategoryPeriodWithAdmin(parcel.readLong(), (RawPeriodInfo) a.d(parcel, RawPeriodInfo.CREATOR), parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeLong(jUpdateCategoryPeriodWithAdmin);
                    return true;
                case TRANSACTION_updateGlobalPeriod /* 73 */:
                    long jUpdateGlobalPeriod = updateGlobalPeriod((RawPeriodInfo) a.d(parcel, RawPeriodInfo.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeLong(jUpdateGlobalPeriod);
                    return true;
                case TRANSACTION_updateGlobalPeriodWithAdmin /* 74 */:
                    long jUpdateGlobalPeriodWithAdmin = updateGlobalPeriodWithAdmin((RawPeriodInfo) a.d(parcel, RawPeriodInfo.CREATOR), parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeLong(jUpdateGlobalPeriodWithAdmin);
                    return true;
                case TRANSACTION_isEnable /* 75 */:
                    boolean zIsEnable = isEnable();
                    parcel2.writeNoException();
                    parcel2.writeInt(zIsEnable ? 1 : 0);
                    return true;
                case TRANSACTION_setEnable /* 76 */:
                    setEnable(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case TRANSACTION_clearAdminLimit /* 77 */:
                    clearAdminLimit(parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case TRANSACTION_addWhitelistApp /* 78 */:
                    addWhitelistApp((WhitelistAppInfo) a.d(parcel, WhitelistAppInfo.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case TRANSACTION_removeWhitelistApp /* 79 */:
                    removeWhitelistApp((WhitelistAppInfo) a.d(parcel, WhitelistAppInfo.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case TRANSACTION_getWhitelistAppListWithAdmin /* 80 */:
                    List<WhitelistAppInfo> whitelistAppListWithAdmin = getWhitelistAppListWithAdmin(parcel.readLong());
                    parcel2.writeNoException();
                    a.e(parcel2, whitelistAppListWithAdmin, 1);
                    return true;
                case TRANSACTION_getWhitelistAppList /* 81 */:
                    List<WhitelistAppInfo> whitelistAppList = getWhitelistAppList();
                    parcel2.writeNoException();
                    a.e(parcel2, whitelistAppList, 1);
                    return true;
                default:
                    return super.onTransact(i5, parcel, parcel2, i6);
            }
        }
    }

    public static class a {
        /* JADX INFO: Access modifiers changed from: private */
        public static <T> T d(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void e(Parcel parcel, List<T> list, int i5) {
            if (list == null) {
                parcel.writeInt(-1);
                return;
            }
            int size = list.size();
            parcel.writeInt(size);
            for (int i6 = 0; i6 < size; i6++) {
                f(parcel, list.get(i6), i5);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void f(Parcel parcel, T t5, int i5) {
            if (t5 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                t5.writeToParcel(parcel, i5);
            }
        }
    }

    long addCategoryPeriod(long j5, RawPeriodInfo rawPeriodInfo);

    long addCategoryPeriodWithAdmin(long j5, RawPeriodInfo rawPeriodInfo, long j6);

    long addGlobalPeriod(RawPeriodInfo rawPeriodInfo);

    long addGlobalPeriodWithAdmin(RawPeriodInfo rawPeriodInfo, long j5);

    long addPackagePeriod(String str, RawPeriodInfo rawPeriodInfo);

    long addPackagePeriodWithAdmin(String str, RawPeriodInfo rawPeriodInfo, long j5);

    long addPeriod(long j5, RawPeriodInfo rawPeriodInfo);

    long addPeriodWithAdmin(long j5, RawPeriodInfo rawPeriodInfo, long j6);

    void addWhitelistApp(WhitelistAppInfo whitelistAppInfo);

    void clearAdminLimit(long j5);

    Category[] getCategories(boolean z5);

    PeriodLimitInfo[] getCategoriesPeriodLimitInfo(long j5);

    Category getCategory(boolean z5, int i5);

    PeriodLimitInfo getCategoryPeriodLimitInfo(long j5, long j6);

    RawPeriodInfo[] getCategoryRawPeriod(long j5);

    RawPeriodInfo[] getCategoryRawPeriodWithAdmin(long j5, long j6);

    CategoryUsingTimeStats[] getCategoryUsingTimeStats(int i5, DataToken dataToken);

    long getCurrentAdmin();

    PeriodLimitInfo getGlobalPeriodLimitInfo(long j5);

    RawPeriodInfo[] getGlobalRawPeriod();

    RawPeriodInfo[] getGlobalRawPeriodWithAdmin(long j5);

    CategoryLimitInfo[] getLimitedCategoriesInfo(boolean z5);

    CategoryLimitInfo getLimitedCategoryInfo(boolean z5, int i5);

    GlobalLimitInfo getLimitedGlobalInfo(boolean z5);

    PackageLimitInfo getLimitedPackageInfo(boolean z5, String str);

    PackageLimitInfo[] getLimitedPackagesInfo(boolean z5);

    PackageNotificationTimesStats[] getPackageNotificationTimesStats(int i5, String str, DataToken dataToken);

    PeriodLimitInfo getPackagePeriodLimitInfo(String str, long j5);

    RawPeriodInfo[] getPackageRawPeriod(String str);

    RawPeriodInfo[] getPackageRawPeriodWithAdmin(String str, long j5);

    PackageUsingTimeStats[] getPackageUsingTimeStats(int i5, String str, DataToken dataToken);

    PackageNotificationTimesStats[] getPackagesNotificationTimesStats(int i5, DataToken dataToken);

    PeriodLimitInfo[] getPackagesPeriodLimitInfo(long j5);

    PackageUsingTimeStats[] getPackagesUsingTimeStats(int i5, DataToken dataToken);

    NotificationTimesStats[] getPhoneNotificationTimesStats(int i5, DataToken dataToken);

    UsingTimeStats[] getPhoneUsingTimeStats(int i5, DataToken dataToken);

    PickupTimesStats[] getPickupTimesStats(int i5, DataToken dataToken);

    RawPeriodInfo[] getRawPeriod(long j5);

    StatsDataSet[] getStatsDataSets(DataToken dataToken);

    List<WhitelistAppInfo> getWhitelistAppList();

    List<WhitelistAppInfo> getWhitelistAppListWithAdmin(long j5);

    void init();

    PeriodLimitInfo initCategoryPeriodLimitInfo(long j5, long j6, boolean z5);

    PeriodLimitInfo initGlobalPeriodLimitInfo();

    PeriodLimitInfo initGlobalPeriodLimitInfoWithAdmin(long j5);

    PeriodLimitInfo initPackagePeriodLimitInfo(String str, long j5, boolean z5);

    boolean isEnable();

    boolean isPackageLimitable(String str);

    DataToken queryUsageData(int i5, boolean z5);

    DataToken queryUsageDataSet(int i5, boolean z5);

    long removeCategoryPeriod(long j5, long j6);

    long removeCategoryPeriodWithAdmin(long j5, long j6, long j7);

    long removeGlobalPeriod(long j5);

    long removeGlobalPeriodWithAdmin(long j5, long j6);

    long removePackagePeriod(String str, long j5);

    long removePackagePeriodWithAdmin(String str, long j5, long j6);

    long removePeriod(long j5, long j6);

    long removePeriodWithAdmin(long j5, long j6, long j7);

    void removeWhitelistApp(WhitelistAppInfo whitelistAppInfo);

    boolean setCategoryLimitTime(int i5, int i6, long j5, long j6, boolean z5, boolean z6);

    boolean setCategoryLimitTimeWithAdmin(int i5, int i6, long j5, long j6, boolean z5, boolean z6, long j7, boolean z7);

    PeriodLimitInfo setCategoryPeriodLimit(long j5, boolean z5, boolean z6);

    PeriodLimitInfo setCategoryPeriodLimitWithAdmin(long j5, boolean z5, boolean z6, long j6, boolean z7);

    void setCurrentAdmin(long j5);

    void setEnable(boolean z5);

    boolean setGlobalLimitTime(int i5, long j5, long j6, boolean z5, boolean z6);

    boolean setGlobalLimitTimeWithAdmin(int i5, long j5, long j6, boolean z5, boolean z6, long j7, boolean z7);

    PeriodLimitInfo setGlobalPeriodLimit(boolean z5, boolean z6);

    PeriodLimitInfo setGlobalPeriodLimitWithAdmin(boolean z5, boolean z6, long j5);

    boolean setPackageLimitTime(int i5, String str, long j5, long j6, boolean z5, boolean z6);

    boolean setPackageLimitTimeWithAdmin(int i5, String str, long j5, long j6, boolean z5, boolean z6, long j7, boolean z7);

    PeriodLimitInfo setPackagePeriodLimit(String str, boolean z5, boolean z6);

    PeriodLimitInfo setPackagePeriodLimitWithAdmin(String str, boolean z5, boolean z6, long j5, boolean z7);

    long updateCategoryPeriod(long j5, RawPeriodInfo rawPeriodInfo);

    long updateCategoryPeriodWithAdmin(long j5, RawPeriodInfo rawPeriodInfo, long j6);

    long updateGlobalPeriod(RawPeriodInfo rawPeriodInfo);

    long updateGlobalPeriodWithAdmin(RawPeriodInfo rawPeriodInfo, long j5);

    long updatePackagePeriod(String str, RawPeriodInfo rawPeriodInfo);

    long updatePackagePeriodWithAdmin(String str, RawPeriodInfo rawPeriodInfo, long j5);

    long updatePeriod(long j5, RawPeriodInfo rawPeriodInfo);

    long updatePeriodWithAdmin(long j5, RawPeriodInfo rawPeriodInfo, long j6);
}
