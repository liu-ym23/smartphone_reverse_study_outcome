package com.android.contacts.numberassistant;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import bytedanceos.app.numberassistant.NumberBaseInfo;
import bytedanceos.app.numberassistant.NumberLogoInfo;
import bytedanceos.app.numberassistant.NumberMarkInfo;
import bytedanceos.app.numberassistant.NumberQueryParams;
import com.android.contacts.ContactsApplication;
import com.android.contacts.ContactsUtils;
import com.android.contacts.R;
import com.android.contacts.util.HanziToPinyin;
import com.android.contacts.util.NumberMarkResource;
import com.android.contacts.widget.AvatarImageView;
import com.obric.legacy.DestroyObservable;
import com.obric.legacy.DestroyObserver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public abstract class NumberInfosManager {
    private static NumberInfosManager sManager;
    protected boolean DEBUG;
    protected final String TAG;

    public static final enum Classify extends Enum<Classify> {
        private static final /* synthetic */ Classify[] $VALUES = null;
        public static final Classify CUSTOMIZE = null;
        public static final Classify DECORATION = null;
        public static final Classify EDUCATION = null;
        public static final Classify EXPRESS = null;
        public static final Classify FRAUD = null;
        public static final Classify HARASSMENT = null;
        public static final Classify HEAD_HUNTER = null;
        public static final Classify HIGH_RISK = null;
        public static final Classify HOUSE_MARKET = null;
        public static final Classify INSURANCE_FINANCE = null;
        public static final Classify LOAN_PROMOTION = null;
        public static final Classify SALES = null;
        public static final Classify TAXI = null;
        private int displayName;
        private int resId;
        private int selector;
        private int type;

        private static /* synthetic */ Classify[] $values() {
            return new Classify[]{HARASSMENT, SALES, HOUSE_MARKET, EXPRESS, FRAUD, HEAD_HUNTER, TAXI, HIGH_RISK, INSURANCE_FINANCE, LOAN_PROMOTION, EDUCATION, DECORATION, CUSTOMIZE};
        }

        static /* synthetic */ int access$000(Classify r0) {
            return r0.resId;
        }

        public static Classify valueOf(String r1) {
            return (Classify) Enum.valueOf(Classify.class, r1);
        }

        public static Classify[] values() {
            return (Classify[]) $VALUES.clone();
        }

        static {
            HARASSMENT = new Classify("HARASSMENT", 0, 1, R.drawable.sign_harassment, R.drawable.mark_harassment_selector, R.string.number_mark_classify_harassment);
            SALES = new Classify("SALES", 1, 2, R.drawable.sign_ad_sales, R.drawable.mark_ad_sales_selector, R.string.number_mark_classify_ad_sales);
            HOUSE_MARKET = new Classify("HOUSE_MARKET", 2, 4, R.drawable.sign_house_market, R.drawable.mark_house_market_selector, R.string.number_mark_classify_house_market);
            EXPRESS = new Classify("EXPRESS", 3, 8, R.drawable.sign_express, R.drawable.mark_express_selector, R.string.number_mark_classify_express);
            FRAUD = new Classify("FRAUD", 4, 16, R.drawable.sign_fraud, R.drawable.mark_fraud_selector, R.string.number_mark_classify_fraud);
            HEAD_HUNTER = new Classify("HEAD_HUNTER", 5, 32, R.drawable.sign_head_hunter, R.drawable.mark_head_hunter_selector, R.string.number_mark_classify_head_hunter);
            TAXI = new Classify("TAXI", 6, 64, R.drawable.sign_taxi, R.drawable.mark_taxi_selector, R.string.number_mark_classify_taxi);
            HIGH_RISK = new Classify("HIGH_RISK", 7, 128, R.drawable.sign_high_risk, R.drawable.mark_high_risk_selector, R.string.number_mark_classify_high_risk);
            INSURANCE_FINANCE = new Classify("INSURANCE_FINANCE", 8, 256, R.drawable.sign_insurance_finance, R.drawable.mark_insurance_finance_selector, R.string.number_mark_classify_insurance);
            LOAN_PROMOTION = new Classify("LOAN_PROMOTION", 9, 512, R.drawable.sign_load_promotion, R.drawable.mark_load_promotion_selector, R.string.number_mark_classify_loan_promotion);
            EDUCATION = new Classify("EDUCATION", 10, 4096, R.drawable.sign_education, R.drawable.mark_education_selector, R.string.number_mark_classify_education);
            DECORATION = new Classify("DECORATION", 11, 8192, R.drawable.sign_decoration, R.drawable.mark_decoration_selector, R.string.number_mark_classify_decoration);
            CUSTOMIZE = new Classify("CUSTOMIZE", 12, 1073741824, -1, R.drawable.mark_tag_selector, R.string.common_custom_marker_content);
            $VALUES = $values();
        }

        private Classify(String r1, int r2, int r3, int r4, int r5, int r6) {
            super(r1, r2);
            this.type = r3;
            this.resId = r4;
            this.selector = r5;
            this.displayName = r6;
        }

        public static Classify getClassifyWithType(int r5) {
            Classify[] r0 = values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L8;
            Classify r3 = r0[r2];
            if (r3.type == r5) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return r3;
        L8:
            return null;
        }

        public static Classify getClassifyByIndex(int r5) {
            Classify[] r0 = values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L8;
            Classify r3 = r0[r2];
            if (r3.ordinal() == r5) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return r3;
        L8:
            return null;
        }

        public static int getClassifyIndexByDisplayName(String r5) {
            Classify[] r0 = values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L13;
            Classify r3 = r0[r2];
            if (TextUtils.isEmpty(r5) == true) goto L12;
            if (TextUtils.isEmpty(r3.getClassifyText()) == true) goto L12;
            if (r3.getClassifyText().contains(r5) == false) goto L12;
            return r3.ordinal();
        L12:
            r2 = r2 + 1;
            goto L3
        L13:
            return -1;
        }

        public static boolean isValidIndex(int r1) {
            if (r1 >= HARASSMENT.ordinal()) goto L5;
        L7:
            return false;
        L5:
            if (r1 > CUSTOMIZE.ordinal()) goto L7;
            return true;
        }

        public int getDrawableResId() {
            return this.resId;
        }

        public int getClassifySelector() {
            return this.selector;
        }

        public String getClassifyText() {
            return ContactsApplication.getInstance().getApplicationContext().getString(this.displayName);
        }

        public int getClassifyType() {
            return this.type;
        }

        public int getDisplayName() {
            return this.displayName;
        }
    }

    public class LinkedNumberInfosListener implements NumberInfosListener {
        private NumberInfosListener mNext;
        private NumberInfosListener mOrigin;
        final /* synthetic */ NumberInfosManager this$0;

        public LinkedNumberInfosListener(NumberInfosManager r1, NumberInfosListener r2) {
            this.this$0 = r1;
            this.mOrigin = r2;
        }

        public synchronized void setNext(NumberInfosListener r1) {
            monitor-enter(this);
            this.mNext = r1;     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        @Override // com.android.contacts.numberassistant.NumberInfosManager.NumberInfosListener
        public void onQueryNumberInfosDone(NumberInfos r2) {
            NumberInfosListener r0 = this.mOrigin;
            if (r0 == null) goto L5;
            r0.onQueryNumberInfosDone(r2);
        L5:
            NumberInfosListener r1 = this.mNext;
            if (r1 == null) goto L9;
            r1.onQueryNumberInfosDone(r2);
            return;
        }

        @Override // com.android.contacts.numberassistant.NumberInfosManager.NumberInfosListener
        public void onQueryYellowPageDone(List<NumberInfos> r2) {
            NumberInfosListener r0 = this.mOrigin;
            if (r0 == null) goto L5;
            r0.onQueryYellowPageDone(r2);
        L5:
            NumberInfosListener r1 = this.mNext;
            if (r1 == null) goto L9;
            r1.onQueryYellowPageDone(r2);
            return;
        }

        @Override // com.android.contacts.numberassistant.NumberInfosManager.NumberInfosListener
        public void onUploadMarkInfoDone(boolean r2) {
            NumberInfosListener r0 = this.mOrigin;
            if (r0 == null) goto L5;
            r0.onUploadMarkInfoDone(r2);
        L5:
            NumberInfosListener r1 = this.mNext;
            if (r1 == null) goto L9;
            r1.onUploadMarkInfoDone(r2);
            return;
        }
    }

    public static class NumberInfos {
        private static final NumberBaseInfo sBaseInfo = null;
        private static final NumberLogoInfo sLogoInfo = null;
        private static final NumberMarkInfo sMarkInfo = null;
        private NumberBaseInfo mBaseInfo;
        private AtomicBoolean mIsClassifyLogo;
        private Bitmap mLogo;
        private NumberLogoInfo mLogoInfo;
        private NumberMarkInfo mMarkInfo;
        private NumberQueryParams mQueryParams;

        static {
            sBaseInfo = new NumberBaseInfo();
            sMarkInfo = new NumberMarkInfo();
            sLogoInfo = new NumberLogoInfo();
        }

        public NumberInfos(NumberQueryParams r2) {
            this(r2, null, null, null);
        }

        public NumberInfos(NumberQueryParams r3, NumberBaseInfo r4, NumberMarkInfo r5, NumberLogoInfo r6) {
            this.mIsClassifyLogo = new AtomicBoolean(false);
            this.mQueryParams = r3;
            this.mBaseInfo = r4;
            this.mMarkInfo = r5;
            this.mLogoInfo = r6;
        }

        NumberInfos(Bitmap r3) {
            this.mIsClassifyLogo = new AtomicBoolean(false);
            this.mLogo = r3;
        }

        void merge(NumberInfos r3) {
            NumberBaseInfo r0 = r3.mBaseInfo;
            if (r0 == null) goto L5;
            this.mBaseInfo = r0;
        L5:
            NumberMarkInfo r1 = r3.mMarkInfo;
            if (r1 == null) goto L8;
            this.mMarkInfo = r1;
        L8:
            NumberLogoInfo r2 = r3.mLogoInfo;
            if (r2 == null) goto L11;
            this.mLogoInfo = r2;
        L11:
            updateLogo();
            NumberQueryParams r4 = this.mQueryParams;
            if (r4 == null) goto L16;
            NumberQueryParams r5 = r3.mQueryParams;
            if (r5 == null) goto L16;
            r4.addQueryType(r5.getQueryType());
            return;
        L16:
            NumberQueryParams r6 = r3.mQueryParams;
            if (r6 == null) goto L21;
            this.mQueryParams = r6;
            return;
        }

        public int getQueryType() {
            return this.mQueryParams.getQueryType();
        }

        public String getNumber() {
            NumberQueryParams r0 = this.mQueryParams;
            if (r0 == null) goto L5;
            String r1 = r0.getFirstNumber();
        L16:
            return PhoneNumberUtils.extractNetworkPortion(r1);
        L5:
            NumberBaseInfo r2 = this.mBaseInfo;
            if (r2 == null) goto L8;
            r1 = r2.getNumber();
            goto L16
        L8:
            NumberMarkInfo r3 = this.mMarkInfo;
            if (r3 == null) goto L11;
            r1 = r3.getNumber();
            goto L16
        L11:
            NumberLogoInfo r4 = this.mLogoInfo;
            if (r4 == null) goto L14;
            r1 = r4.getNumber();
            goto L16
        L14:
            r1 = null;
            goto L16
        }

        public String getName() {
            NumberBaseInfo r0 = this.mBaseInfo;
            if (r0 != null) goto L5;
            return null;
        L5:
            return r0.getOrganizationName();
        }

        public String getCity() {
            NumberBaseInfo r0 = this.mBaseInfo;
            if (r0 != null) goto L5;
            return null;
        L5:
            return r0.getArea();
        }

        public String getOperator() {
            NumberBaseInfo r0 = this.mBaseInfo;
            if (r0 != null) goto L5;
            return null;
        L5:
            return r0.getOperator();
        }

        public String getMark() {
            NumberMarkInfo r0 = this.mMarkInfo;
            if (r0 != null) goto L7;
            return "";
        L7:
            return MarkInfoUtil.getMarkClassifyChineseString(r0);
        }

        public int getSource() {
            NumberMarkInfo r0 = this.mMarkInfo;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.getMarkSource();
        }

        public String getOrgNameOrCustomMark() {
            NumberMarkInfo r0 = this.mMarkInfo;
            if (r0 == null) goto L5;
            String r1 = r0.getCustomizeMarkString();
        L7:
            if (TextUtils.isEmpty(r1) == true) goto L9;
            return r1;
        L9:
            return getName();
        L5:
            r1 = null;
            goto L7
        }

        public String getLabel() {
            String r0 = getMark();
            String r1 = getName();
            String r2 = getLocation();
            NumberBaseInfo r3 = this.mBaseInfo;
            if (r3 == null) goto L5;
            String r4 = r3.getOperator();
        L7:
            if (TextUtils.isEmpty(r0) == false) goto L10;
            r0 = r1;
        L10:
            if (TextUtils.isEmpty(r0) == true) goto L12;
        L16:
            r2 = r0;
        L18:
            if (TextUtils.isEmpty(r2) == true) goto L20;
            return r2;
        L20:
            return ContactsApplication.getInstance().getApplicationContext().getString(R.string.unknown);
        L12:
            if (this.mBaseInfo == null) goto L16;
            if (TextUtils.isEmpty(r2) == true) goto L18;
            r2 = r2 + HanziToPinyin.Token.SEPARATOR + r4;
            goto L18
        L5:
            r4 = null;
            goto L7
        }

        public String getLocation() {
            NumberBaseInfo r0 = this.mBaseInfo;
            if (r0 != null) goto L7;
            return "";
        L7:
            return r0.getLocation();
        }

        public Bitmap getLogo() {
            return this.mLogo;
        }

        public boolean isMarked() {
            if (hasQueriedDone(2) == true) goto L5;
            return false;
        L5:
            if (this.mMarkInfo.getMarkSource() != 3) goto L9;
            return true;
        L9:
            return false;
        }

        public int getClassifyDrawableRes() {
            if (hasQueriedDone(2) == false) goto L8;
            Classify r1 = Classify.getClassifyWithType(this.mMarkInfo.getMainMarkClassify());
            if (r1 != null) goto L7;
            return -1;
        L7:
            return Classify.access$000(r1);
        L8:
            return -1;
        }

        public String getClassifyString() {
            if (hasQueriedDone(2) == true) goto L5;
            return null;
        L5:
            return NumberMarkInfo.getMarkClassifyTypeString(ContactsApplication.getInstance().getApplicationContext(), this.mMarkInfo.getMainMarkClassify());
        }

        public int getNumberMainMarkClassify() {
            NumberMarkInfo r0 = this.mMarkInfo;
            if (r0 != null) goto L7;
            return -1;
        L7:
            return r0.getMainMarkClassify();
        }

        public void setNumberBaseInfo(String r1, NumberBaseInfo r2) {
            if (r2 != null) goto L5;
            r2 = sBaseInfo;
        L5:
            this.mBaseInfo = r2;
        }

        public void setNumberMarkInfo(String r1, NumberMarkInfo r2) {
            if (r2 == null) goto L4;
            this.mMarkInfo = r2;
            updateLogo();
            return;
        L4:
            this.mMarkInfo = sMarkInfo;
        }

        public void setNumberLogoInfo(String r1, NumberLogoInfo r2) {
            if (r2 == null) goto L4;
            this.mLogoInfo = r2;
            updateLogo();
            return;
        L4:
            this.mLogoInfo = sLogoInfo;
        }

        private void updateLogo() {
            if (this.mMarkInfo == null) goto L7;
            int r0 = getClassifyDrawableRes();
            if (r0 <= 0) goto L7;
            Bitmap r1 = NumberMarkResource.getInstance(ContactsApplication.getInstance()).getResource(r0);
            this.mIsClassifyLogo.set(true);
        L8:
            NumberLogoInfo r2 = this.mLogoInfo;
            if (r2 == null) goto L13;
            byte[] r3 = r2.getLogoByte();
            if (r3 == null) goto L13;
            r1 = BitmapFactory.decodeByteArray(r3, 0, r3.length);
            this.mIsClassifyLogo.set(false);
        L13:
            this.mLogo = r1;
            if (r1 != null) goto L17;
            this.mIsClassifyLogo.set(false);
            return;
        L17:
            return;
        L7:
            r1 = null;
            goto L8
        }

        public boolean isClassifyLogo() {
            return this.mIsClassifyLogo.get();
        }

        public boolean hasQueriedDone() {
            if (this.mQueryParams.isQueryBase() == false) goto L8;
            if (this.mBaseInfo != null) goto L8;
            return false;
        L8:
            if (this.mQueryParams.isQueryLogo() == false) goto L13;
            if (this.mLogoInfo != null) goto L13;
            return false;
        L13:
            if (this.mQueryParams.isQueryMark() == true) goto L15;
            return true;
        L15:
            if (this.mMarkInfo != null) goto L19;
            return false;
        L19:
            return true;
        }

        public boolean hasQueriedDone(int r3) {
            if (r3 != 1) goto L8;
            if (this.mBaseInfo == null) goto L8;
            return true;
        L8:
            if (r3 != 2) goto L13;
            if (this.mMarkInfo == null) goto L13;
            return true;
        L13:
            if (r3 == 4) goto L15;
            return false;
        L15:
            if (this.mLogoInfo == null) goto L19;
            return true;
        L19:
            return false;
        }

        public void clearMarkInfo() {
            this.mMarkInfo = null;
            updateLogo();
        }

        public static List<NumberInfos> newNumberInfosList(NumberQueryParams r4) {
            ArrayList r0 = new ArrayList();
            Iterator r1 = r4.getNumberList().iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            NumberQueryParams r3 = new NumberQueryParams((String) r1.next());
            r3.setQueryStrategy(r4.getQueryStrategy());
            r3.setQueryType(r4.getQueryType());
            r0.add(new NumberInfos(r3));
            goto L4
        L6:
            return r0;
        }

        public String toString() {
            return "[NumberInfos]: 【QueriedWrapper=" + this.mQueryParams + "】\n【BaseInfos=" + this.mBaseInfo + "】\n【MarkInfos=" + this.mMarkInfo + "】\n【LogoInfos=" + this.mLogoInfo + "】\n【mLogo=" + this.mLogo + "】";
        }
    }

    public interface NumberInfosListener {
        void onQueryNumberInfosDone(NumberInfos r1);

        void onQueryYellowPageDone(List<NumberInfos> r1);

        void onUploadMarkInfoDone(boolean r1);
    }

    public static class NumberInfosListenerAdatper implements NumberInfosListener {
        @Override // com.android.contacts.numberassistant.NumberInfosManager.NumberInfosListener
        public void onQueryNumberInfosDone(NumberInfos r1) {
        }

        @Override // com.android.contacts.numberassistant.NumberInfosManager.NumberInfosListener
        public void onQueryYellowPageDone(List<NumberInfos> r1) {
        }

        @Override // com.android.contacts.numberassistant.NumberInfosManager.NumberInfosListener
        public void onUploadMarkInfoDone(boolean r1) {
        }

        public NumberInfosListenerAdatper() {
        }

        public NumberInfosListener toDestroyObservable(DestroyObservable r2) {
            return new NumberInfosListenerForDestroyable(r2, this);
        }
    }

    public static final class NumberInfosListenerForDestroyable extends NumberInfosListenerProxy implements DestroyObserver {
        @Override // com.android.contacts.numberassistant.NumberInfosManager.NumberInfosListenerProxy
        public void setOrigin(NumberInfosListener r1) {
        }

        public NumberInfosListenerForDestroyable(DestroyObservable r2, NumberInfosListener r3) {
            if (r2.isDestroyed() == true) goto L6;
            super.setOrigin(r3);
            r2.addObserver(this);
            return;
        }

        @Override // com.obric.legacy.DestroyObserver
        public void onDestroy(Object r1) {
            super.setOrigin(null);
        }
    }

    public static class NumberInfosListenerProxy implements NumberInfosListener {
        private NumberInfosListener mOrigin;

        public NumberInfosListenerProxy() {
        }

        public void setOrigin(NumberInfosListener r1) {
            this.mOrigin = r1;
        }

        @Override // com.android.contacts.numberassistant.NumberInfosManager.NumberInfosListener
        public void onQueryNumberInfosDone(NumberInfos r1) {
            NumberInfosListener r0 = this.mOrigin;
            if (r0 == null) goto L6;
            r0.onQueryNumberInfosDone(r1);
            return;
        }

        @Override // com.android.contacts.numberassistant.NumberInfosManager.NumberInfosListener
        public void onQueryYellowPageDone(List<NumberInfos> r1) {
            NumberInfosListener r0 = this.mOrigin;
            if (r0 == null) goto L6;
            r0.onQueryYellowPageDone(r1);
            return;
        }

        @Override // com.android.contacts.numberassistant.NumberInfosManager.NumberInfosListener
        public void onUploadMarkInfoDone(boolean r1) {
            NumberInfosListener r0 = this.mOrigin;
            if (r0 == null) goto L6;
            r0.onUploadMarkInfoDone(r1);
            return;
        }
    }

    public abstract void bindPublicNumberLogoAsync(String r1, AvatarImageView r2, Bitmap r3);

    public abstract void clearMarkInfoAsync(String r1, NumberInfosListener r2);

    public abstract void getBaseAndMarkInfos(String r1, NumberInfosListener r2);

    public abstract void getBaseAndMarkInfosAsync(String r1, NumberInfosListener r2);

    public abstract void getBaseAndMarkInfosAsync(List<String> r1, NumberInfosListener r2);

    public abstract void getBaseAndMarkOfflineAsync(String r1, NumberInfosListener r2);

    public abstract void getBaseInfos(String r1, NumberInfosListener r2);

    public abstract NumberInfos getCachedBaseAndMarkInfos(String r1);

    public abstract NumberInfos getCachedLogoInfos(String r1);

    public abstract void getPublicNumberLogoAsync(String r1, NumberInfosListener r2);

    public abstract void getYellowPageDataAsync(String r1, NumberInfosListener r2);

    public abstract void setCustomMarkInfoAsync(String r1, String r2, NumberInfosListener r3);

    public abstract void setMarkInfoAsync(String r1, int r2, NumberInfosListener r3);

    public NumberInfosManager() {
        this.TAG = "NumberInfosManager";
        if (ContactsUtils.DEBUG == false) goto L5;
    L8:
        boolean r0 = true;
    L9:
        this.DEBUG = r0;
        return;
    L5:
        if (ContactsUtils.USER_LOG_ON == true) goto L8;
        r0 = false;
        goto L9
    }

    public static synchronized NumberInfosManager getInstance() {
        monitor-enter(NumberInfosManager.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sManager != null) goto L7;
        sManager = new NumberInfosManagerImpl();     // Catch: Throwable -> L10
    L7:
        NumberInfosManager r1 = sManager;     // Catch: Throwable -> L10
        monitor-exit(NumberInfosManager.class);
        return r1;
    }
}
