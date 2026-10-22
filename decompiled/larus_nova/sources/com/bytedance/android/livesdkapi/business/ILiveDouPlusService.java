package com.bytedance.android.livesdkapi.business;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import bz.a;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.base.model.UrlModel;
import com.bytedance.android.live.base.model.commerce.DouPlusEntry;
import com.bytedance.android.livesdk.app.dataholder.Observer;
import io.reactivex.disposables.Disposable;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public interface ILiveDouPlusService extends IService {

    public static class DEFAULT implements ILiveDouPlusService {
        public DEFAULT() {
        }

        @Override // com.bytedance.android.livesdkapi.business.ILiveDouPlusService
        public void adLiveOpenSuccess(String r100, long r101, Map<String, String> r102) {
        }

        @Override // com.bytedance.android.livesdkapi.business.ILiveDouPlusService
        public void douPlusMonitor(String r100, int r101, JSONObject r102) {
        }

        @Override // com.bytedance.android.livesdkapi.business.ILiveDouPlusService
        public JSONObject getClientDouPlusPopupSettings() {
            return null;
        }

        @Override // com.bytedance.android.livesdkapi.business.ILiveDouPlusService
        public void getDouLiveIndicatorStatus(String r100, long r101, boolean r102, Observer<a> r103) {
        }

        @Override // com.bytedance.android.livesdkapi.business.ILiveDouPlusService
        public String getDouPlusLiveEntryPath() {
            return "";
        }

        @Override // com.bytedance.android.livesdkapi.business.ILiveDouPlusService
        public int getDouPlusLogoResId(boolean r100, boolean r101) {
            return 0;
        }

        @Override // com.bytedance.android.livesdkapi.business.ILiveDouPlusService
        public int getDouPlusPreviewLogoResId() {
            return 0;
        }

        @Override // com.bytedance.android.livesdkapi.business.ILiveDouPlusService
        public UrlModel getEnterRoomClickTrackUrlList(long r100) {
            return null;
        }

        @Override // com.bytedance.android.livesdkapi.business.ILiveDouPlusService
        public String getLocalPromotionIdentity() {
            return "2";
        }

        @Override // com.bytedance.android.livesdkapi.business.ILiveDouPlusService
        public boolean getRenQiBaoSwitch(String r100) {
            return false;
        }

        @Override // com.bytedance.android.livesdkapi.business.ILiveDouPlusService
        public void getRenQiBaoSwitchResult(String r100, IRenQiBaoSwitchCallback r101) {
        }

        @Override // com.bytedance.android.livesdkapi.business.ILiveDouPlusService
        public boolean hasLiveAdDialogShowing() {
            return false;
        }

        @Override // com.bytedance.android.livesdkapi.business.ILiveDouPlusService
        public boolean isFixLiveDouPlusGetRenQiBaoANREnabled() {
            return false;
        }

        @Override // com.bytedance.android.livesdkapi.business.ILiveDouPlusService
        public boolean isNeedDouPlusEntry() {
            return false;
        }

        @Override // com.bytedance.android.livesdkapi.business.ILiveDouPlusService
        public void logEvent(boolean r100, String r101, String r102, Map<String, String> r103) {
        }

        @Override // com.bytedance.android.livesdkapi.business.ILiveDouPlusService
        public void notifyAdxCoinTaskCompleted() {
        }

        @Override // com.bytedance.android.livesdkapi.business.ILiveDouPlusService
        public void onLiveEnd() {
        }

        @Override // com.bytedance.android.livesdkapi.business.ILiveDouPlusService
        public Dialog onLocalPromotionClick(View r100, String r101, boolean r102, OnLiveDouPlusDialogListener r103) {
            return null;
        }

        @Override // com.bytedance.android.livesdkapi.business.ILiveDouPlusService
        public void sendThirdTrack(String r100, UrlModel r101, Long r102, String r103) {
        }

        @Override // com.bytedance.android.livesdkapi.business.ILiveDouPlusService
        public boolean shouldBlockEcpLiveEntry() {
            return false;
        }

        @Override // com.bytedance.android.livesdkapi.business.ILiveDouPlusService
        public boolean shouldShowLocalPromotion() {
            return false;
        }

        @Override // com.bytedance.android.livesdkapi.business.ILiveDouPlusService
        public void showDialogContent(Dialog r100, boolean r101) {
        }

        @Override // com.bytedance.android.livesdkapi.business.ILiveDouPlusService
        public Dialog showDouPlusDialog(Context r100, Map<String, String> r101, String r102, OnLiveDouPlusDialogListener r103) {
            return null;
        }

        @Override // com.bytedance.android.livesdkapi.business.ILiveDouPlusService
        public void showDouPlusLiveEntry(String r100, long r101, String r102, Observer<DouPlusEntry> r103) {
        }

        @Override // com.bytedance.android.livesdkapi.business.ILiveDouPlusService
        public Dialog showLocalAdsDialog(Context r100, Map<String, String> r101, String r102, OnLiveDouPlusDialogListener r103) {
            return null;
        }

        @Override // com.bytedance.android.livesdkapi.business.ILiveDouPlusService
        public void showLocalPromotion(View r100) {
        }

        @Override // com.bytedance.android.livesdkapi.business.ILiveDouPlusService
        public void showOrders(Context r100, String r101) {
        }

        @Override // com.bytedance.android.livesdkapi.business.ILiveDouPlusService
        public Disposable showVSDouPlusDialog(Context r100, Map<String, String> r101, Map<String, String> r102, OnLiveDouPlusDialogListener r103) {
            return null;
        }

        @Override // com.bytedance.android.livesdkapi.business.ILiveDouPlusService
        public ILiveDouPlusEcpService getEcpService() {
            return new ILiveDouPlusEcpService.Stub();
        }

        @Override // com.bytedance.android.livesdkapi.business.ILiveDouPlusService
        public void fetchDouLiveCouponToast(Observer<String> r100) {
            r100.onChanged("Stub!");
        }
    }

    void adLiveOpenSuccess(String r100, long r101, Map<String, String> r102);

    void douPlusMonitor(String r100, int r101, JSONObject r102);

    void fetchDouLiveCouponToast(Observer<String> r100);

    JSONObject getClientDouPlusPopupSettings();

    void getDouLiveIndicatorStatus(String r100, long r101, boolean r102, Observer<a> r103);

    String getDouPlusLiveEntryPath();

    int getDouPlusLogoResId(boolean r100, boolean r101);

    int getDouPlusPreviewLogoResId();

    ILiveDouPlusEcpService getEcpService();

    UrlModel getEnterRoomClickTrackUrlList(long r100);

    String getLocalPromotionIdentity();

    boolean getRenQiBaoSwitch(String r100);

    void getRenQiBaoSwitchResult(String r100, IRenQiBaoSwitchCallback r101);

    boolean hasLiveAdDialogShowing();

    boolean isFixLiveDouPlusGetRenQiBaoANREnabled();

    boolean isNeedDouPlusEntry();

    void logEvent(boolean r100, String r101, String r102, Map<String, String> r103);

    void notifyAdxCoinTaskCompleted();

    void onLiveEnd();

    Dialog onLocalPromotionClick(View r100, String r101, boolean r102, OnLiveDouPlusDialogListener r103);

    void sendThirdTrack(String r100, UrlModel r101, Long r102, String r103);

    boolean shouldBlockEcpLiveEntry();

    boolean shouldShowLocalPromotion();

    void showDialogContent(Dialog r100, boolean r101);

    Dialog showDouPlusDialog(Context r100, Map<String, String> r101, String r102, OnLiveDouPlusDialogListener r103);

    void showDouPlusLiveEntry(String r100, long r101, String r102, Observer<DouPlusEntry> r103);

    Dialog showLocalAdsDialog(Context r100, Map<String, String> r101, String r102, OnLiveDouPlusDialogListener r103);

    void showLocalPromotion(View r100);

    void showOrders(Context r100, String r101);

    Disposable showVSDouPlusDialog(Context r100, Map<String, String> r101, Map<String, String> r102, OnLiveDouPlusDialogListener r103);
}
