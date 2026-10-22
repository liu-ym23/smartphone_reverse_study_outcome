package com.android.ttcjpaysdk.base.service;

import android.content.Context;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public interface ICJPayAgreementService extends ICJPayService {

    public static class AgreementDetailParams {
        public int height;
        public boolean isBackClose;
        public boolean isCardStyle;
        public boolean isFromDialog;
        public String title;
        public String url;

        public AgreementDetailParams(String r100, String r101, int r102, boolean r103, boolean r104, boolean r105) {
            this.url = r100;
            this.title = r101;
            this.height = r102;
            this.isBackClose = r103;
            this.isCardStyle = r104;
            this.isFromDialog = r105;
        }
    }

    Fragment getAgreementDetailFragment(AgreementDetailParams r100);

    void startCJPayAgreementActivity(Context r100, ArrayList<JSONObject> r101, int r102, boolean r103, ICJPayAgreementCallback r104);

    void startCJPayAgreementActivity(Context r100, ArrayList<JSONObject> r101, boolean r102, ICJPayAgreementCallback r103);

    void startCJPayAgreementActivityWithHeight(Context r100, ArrayList<JSONObject> r101, int r102, boolean r103, ICJPayAgreementCallback r104);

    void startCJPayAgreementActivityWithHeight(Context r100, ArrayList<JSONObject> r101, int r102, boolean r103, boolean r104, ICJPayAgreementCallback r105);
}
