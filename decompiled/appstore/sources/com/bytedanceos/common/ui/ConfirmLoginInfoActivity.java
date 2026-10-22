package com.bytedanceos.common.ui;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.RelativeLayout;
import com.bytedanceos.common.R$anim;
import com.bytedanceos.common.R$id;
import com.bytedanceos.common.R$layout;
import com.bytedanceos.common.network.FetchDataCallBack;
import com.bytedanceos.common.toolbox.cache.AccountDataCache;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public class ConfirmLoginInfoActivity extends StatusBarActivity implements FetchDataCallBack, View.OnClickListener {
    public static final int CHECK_PASSWORD = 1;
    public static final int GET_NICK_NAME = 2;
    public static final int RESULT_FAILURE = -1;
    public static final int RESULT_SUCCESS = 1;
    public static final String SCREEN_MODE = "screen_mode";
    public static final String TYPE = "type";
    private boolean isBigScreenMode;
    protected AccountDataCache mAccountCache;
    private RelativeLayout mCheckPasswordContanier;
    private RelativeLayout mNickNameContanier;
    private String mNickname;
    private EditText mNicknameEditText;
    private String mPassWord;
    private int mType;

    public class MyTextWatcher implements TextWatcher {
        final /* synthetic */ ConfirmLoginInfoActivity this$0;

        public MyTextWatcher(ConfirmLoginInfoActivity r10) {
            this.this$0 = r10;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable r10) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence r10, int r11, int r12, int r13) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence r10, int r11, int r12, int r13) {
        }
    }

    public ConfirmLoginInfoActivity() {
    }

    public static /* synthetic */ void access$000(ConfirmLoginInfoActivity r10, String r11) {
        r10.handleMsgCheckPassWord(r11);
    }

    public static /* synthetic */ void access$100(ConfirmLoginInfoActivity r10, String r11) {
        r10.handleMsgSetNickName(r11);
    }

    private void doSubmitNickname() {
        this.mNickname = ((EditText) findViewById(R$id.nickname)).getText().toString();
        w8.a.j0().m0(this.mNickname, this);
    }

    private void doSubmitPassword() {
    }

    private void handleMsgCheckPassWord(String r10) {
        RelativeLayout r11 = this.mCheckPasswordContanier;
        if (r11 == null) goto L9;
        RelativeLayout r12 = this.mNickNameContanier;
        if (r12 == null) goto L10;
        this.mType = 2;
        startAnimation(r11, r12);
        this.mNicknameEditText.requestFocus();
        return;
    L10:
        return;
    }

    private void handleMsgSetNickName(String r10) {
        this.mAccountCache.s(this.mNickname);
        this.mAccountCache.w(this.mNickname);
        setResult(1);
        finish();
        overridePendingTransition(R$anim.fake_anim, R$anim.slide_down_out);
    }

    public static boolean validNickname(String r10) {
        if (Pattern.compile("[a-zA-Z0-9一-龥\\_]{2,15}").matcher(r10.trim()).matches() == false) goto L17;
        int r11 = 0;
        int r12 = 0;
    L6:
        if (r11 >= r10.length()) goto L11;
        int r13 = r11 + 1;
        if (Pattern.matches("[一-龥]", r10.substring(r11, r13)) == false) goto L10;
        r12 = r12 + 1;
    L10:
        r11 = r13;
        goto L6
    L11:
        int r14 = r10.length() + r12;
        if (r14 < 3) goto L17;
        if (r14 > 15) goto L17;
        return true;
    L17:
        return false;
    }

    public static boolean validPassword(String r10) {
        if (r10.length() >= 6) goto L5;
    L7:
        return false;
    L5:
        if (r10.length() > 16) goto L7;
        return true;
    }

    public String getNickname() {
        return this.mNickname;
    }

    public String getPassword() {
        return this.mPassWord;
    }

    @Override // com.bytedanceos.common.ui.StatusBarActivity
    public View initHeaderView() {
        return findViewById(R$id.main_header);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        finish();
        overridePendingTransition(R$anim.fake_anim, R$anim.slide_down_out);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r10) {
    }

    @Override // com.bytedanceos.common.ui.StatusBarActivity, com.bytedanceos.common.ui.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r10) {
        super.onCreate(r10);
        setContentView(R$layout.confirm_login_info);
        int r11 = 0;
        this.mType = getIntent().getIntExtra("type", 1);     // Catch: Exception -> L5
        this.isBigScreenMode = getIntent().getBooleanExtra(SCREEN_MODE, false);     // Catch: Exception -> L5
    L7:
        this.mCheckPasswordContanier = (RelativeLayout) findViewById(R$id.check_password_container);
        this.mNickNameContanier = (RelativeLayout) findViewById(R$id.nick_name_container);
        RelativeLayout r12 = this.mCheckPasswordContanier;
        if (this.mType != 1) goto L10;
        int r13 = 0;
    L11:
        r12.setVisibility(r13);
        RelativeLayout r14 = this.mNickNameContanier;
        if (this.mType != 1) goto L14;
        r11 = 8;
    L14:
        r14.setVisibility(r11);
        findViewById(R$id.password_cancel).setOnClickListener(this);
        findViewById(R$id.nickname_cancel).setOnClickListener(this);
        EditText r15 = (EditText) findViewById(R$id.nickname);
        this.mNicknameEditText = r15;
        r15.addTextChangedListener(new MyTextWatcher(this));
        this.mAccountCache = AccountDataCache.b();
        return;
    L10:
        r13 = 8;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    @Override // com.bytedanceos.common.network.FetchDataCallBack
    public void onFetchDataFailed(final int r10, final Throwable r11, final String r12, Object r13) {
        runOnUiThread(new AnonymousClass1(this, r11, r12, r10));
    }

    @Override // com.bytedanceos.common.network.FetchDataCallBack
    public void onFetchDataSuccess(final int r10, int r11, final String r12, Object r13, String r14) {
        runOnUiThread(new AnonymousClass2(this, r10, r12));
    }

    @Override // com.bytedanceos.common.ui.StatusBarActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    public void setViewAnimation(ViewGroup r10, int r11) {
        Animation r12 = AnimationUtils.loadAnimation(this, r11);
        r10.clearAnimation();     // Catch: Exception -> L5
    L7:
        r10.startAnimation(r12);
        return;
    L5:
        e = move-exception;
        e.getStackTrace();
        goto L7
    }

    public void startAnimation(ViewGroup r10, ViewGroup r11) {
        if (r10 == null) goto L7;
        if (r11 == null) goto L8;
        r10.setVisibility(8);
        r11.setVisibility(0);
        setViewAnimation(r10, R$anim.slide_out_to_left);
        setViewAnimation(r11, R$anim.slide_in_from_right);
        return;
    L8:
        return;
    }
}
