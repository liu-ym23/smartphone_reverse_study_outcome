package com.facebook.rebound.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TextView;
import com.facebook.rebound.OrigamiValueConverter;
import com.facebook.rebound.Spring;
import com.facebook.rebound.SpringConfig;
import com.facebook.rebound.SpringConfigRegistry;
import com.facebook.rebound.SpringListener;
import com.facebook.rebound.SpringSystem;
import com.ttnet.org.chromium.net.PrivateKeyType;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class SpringConfiguratorView extends FrameLayout {
    private static final DecimalFormat DECIMAL_FORMAT = null;
    private static final float MAX_FRICTION = 50.0f;
    private static final int MAX_SEEKBAR_VAL = 100000;
    private static final float MAX_TENSION = 200.0f;
    private static final float MIN_FRICTION = 0.0f;
    private static final float MIN_TENSION = 0.0f;
    private TextView mFrictionLabel;
    private SeekBar mFrictionSeekBar;
    private final float mRevealPx;
    private final Spring mRevealerSpring;
    private SpringConfig mSelectedSpringConfig;
    private final List<SpringConfig> mSpringConfigs;
    private Spinner mSpringSelectorSpinner;
    private final float mStashPx;
    private TextView mTensionLabel;
    private SeekBar mTensionSeekBar;
    private final int mTextColor;
    private final SpinnerAdapter spinnerAdapter;
    private final SpringConfigRegistry springConfigRegistry;

    /* JADX INFO: renamed from: com.facebook.rebound.ui.SpringConfiguratorView$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public class OnNubTouchListener implements View.OnTouchListener {
        final /* synthetic */ SpringConfiguratorView this$0;

        private OnNubTouchListener(SpringConfiguratorView r10) {
            this.this$0 = r10;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View r10, MotionEvent r11) {
            if (r11.getAction() != 0) goto L7;
            SpringConfiguratorView.access$1200(this.this$0);
            return true;
        L7:
            return true;
        }

        public /* synthetic */ OnNubTouchListener(SpringConfiguratorView r10, AnonymousClass1 r11) {
            this(r10);
        }
    }

    public class RevealerSpringListener implements SpringListener {
        final /* synthetic */ SpringConfiguratorView this$0;

        private RevealerSpringListener(SpringConfiguratorView r10) {
            this.this$0 = r10;
        }

        @Override // com.facebook.rebound.SpringListener
        public void onSpringActivate(Spring r10) {
        }

        @Override // com.facebook.rebound.SpringListener
        public void onSpringAtRest(Spring r10) {
        }

        @Override // com.facebook.rebound.SpringListener
        public void onSpringEndStateChange(Spring r10) {
        }

        @Override // com.facebook.rebound.SpringListener
        public void onSpringUpdate(Spring r10) {
            float r11 = (float) r10.getCurrentValue();
            float r12 = SpringConfiguratorView.access$1300(this.this$0);
            float r13 = (r11 * (SpringConfiguratorView.access$1400(this.this$0) - r12)) + r12;
            this.this$0.setTranslationY(r13);
        }

        public /* synthetic */ RevealerSpringListener(SpringConfiguratorView r10, AnonymousClass1 r11) {
            this(r10);
        }
    }

    public class SeekbarListener implements SeekBar.OnSeekBarChangeListener {
        final /* synthetic */ SpringConfiguratorView this$0;

        private SeekbarListener(SpringConfiguratorView r10) {
            this.this$0 = r10;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar r10, int r11, boolean r12) {
            if (r10 != SpringConfiguratorView.access$700(this.this$0)) goto L6;
            float r13 = ((r11 * SpringConfiguratorView.MAX_TENSION) / 100000.0f) + 0.0f;
            double r14 = r13;
            SpringConfiguratorView.access$400(this.this$0).tension = OrigamiValueConverter.tensionFromOrigamiValue(r14);
            String r15 = SpringConfiguratorView.access$800().format(r14);
            SpringConfiguratorView.access$900(this.this$0).setText("T:" + r15);
        L6:
            if (r10 != SpringConfiguratorView.access$1000(this.this$0)) goto L9;
            float r16 = ((r11 * SpringConfiguratorView.MAX_FRICTION) / 100000.0f) + 0.0f;
            double r17 = r16;
            SpringConfiguratorView.access$400(this.this$0).friction = OrigamiValueConverter.frictionFromOrigamiValue(r17);
            String r18 = SpringConfiguratorView.access$800().format(r17);
            SpringConfiguratorView.access$1100(this.this$0).setText("F:" + r18);
            return;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar r10) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar r10) {
        }

        public /* synthetic */ SeekbarListener(SpringConfiguratorView r10, AnonymousClass1 r11) {
            this(r10);
        }
    }

    public class SpinnerAdapter extends BaseAdapter {
        private final Context mContext;
        private final List<String> mStrings;
        final /* synthetic */ SpringConfiguratorView this$0;

        public SpinnerAdapter(SpringConfiguratorView r10, Context r11) {
            this.this$0 = r10;
            this.mContext = r11;
            this.mStrings = new ArrayList();
        }

        public void add(String r10) {
            this.mStrings.add(r10);
            notifyDataSetChanged();
        }

        public void clear() {
            this.mStrings.clear();
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.mStrings.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int r10) {
            return this.mStrings.get(r10);
        }

        @Override // android.widget.Adapter
        public long getItemId(int r10) {
            return r10;
        }

        @Override // android.widget.Adapter
        public View getView(int r10, View r11, ViewGroup r12) {
            if (r11 != null) goto L4;
            TextView r13 = new TextView(this.mContext);
            r13.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
            int r14 = Util.dpToPx(12.0f, this.this$0.getResources());
            r13.setPadding(r14, r14, r14, r14);
            r13.setTextColor(SpringConfiguratorView.access$1500(this.this$0));
        L5:
            r13.setText(this.mStrings.get(r10));
            return r13;
        L4:
            r13 = (TextView) r11;
            goto L5
        }
    }

    public class SpringSelectedListener implements AdapterView.OnItemSelectedListener {
        final /* synthetic */ SpringConfiguratorView this$0;

        private SpringSelectedListener(SpringConfiguratorView r10) {
            this.this$0 = r10;
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> r10, View r11, int r12, long r13) {
            SpringConfiguratorView r14 = this.this$0;
            SpringConfiguratorView.access$402(r14, (SpringConfig) SpringConfiguratorView.access$500(r14).get(r12));
            SpringConfiguratorView r15 = this.this$0;
            SpringConfiguratorView.access$600(r15, SpringConfiguratorView.access$400(r15));
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> r10) {
        }

        public /* synthetic */ SpringSelectedListener(SpringConfiguratorView r10, AnonymousClass1 r11) {
            this(r10);
        }
    }

    static {
        DECIMAL_FORMAT = new DecimalFormat("#.#");
    }

    public SpringConfiguratorView(Context r10) {
        this(r10, null);
    }

    public static /* synthetic */ SeekBar access$1000(SpringConfiguratorView r10) {
        return r10.mFrictionSeekBar;
    }

    public static /* synthetic */ TextView access$1100(SpringConfiguratorView r10) {
        return r10.mFrictionLabel;
    }

    public static /* synthetic */ void access$1200(SpringConfiguratorView r10) {
        r10.togglePosition();
    }

    public static /* synthetic */ float access$1300(SpringConfiguratorView r10) {
        return r10.mRevealPx;
    }

    public static /* synthetic */ float access$1400(SpringConfiguratorView r10) {
        return r10.mStashPx;
    }

    public static /* synthetic */ int access$1500(SpringConfiguratorView r10) {
        return r10.mTextColor;
    }

    public static /* synthetic */ SpringConfig access$400(SpringConfiguratorView r10) {
        return r10.mSelectedSpringConfig;
    }

    public static /* synthetic */ SpringConfig access$402(SpringConfiguratorView r10, SpringConfig r11) {
        r10.mSelectedSpringConfig = r11;
        return r11;
    }

    public static /* synthetic */ List access$500(SpringConfiguratorView r10) {
        return r10.mSpringConfigs;
    }

    public static /* synthetic */ void access$600(SpringConfiguratorView r10, SpringConfig r11) {
        r10.updateSeekBarsForSpringConfig(r11);
    }

    public static /* synthetic */ SeekBar access$700(SpringConfiguratorView r10) {
        return r10.mTensionSeekBar;
    }

    public static /* synthetic */ DecimalFormat access$800() {
        return DECIMAL_FORMAT;
    }

    public static /* synthetic */ TextView access$900(SpringConfiguratorView r10) {
        return r10.mTensionLabel;
    }

    private View generateHierarchy(Context r15) {
        Resources r10 = getResources();
        int r11 = Util.dpToPx(5.0f, r10);
        int r12 = Util.dpToPx(10.0f, r10);
        int r13 = Util.dpToPx(20.0f, r10);
        TableLayout.LayoutParams r14 = new TableLayout.LayoutParams(0, -2, 1.0f);
        r14.setMargins(0, 0, r11, 0);
        FrameLayout r16 = new FrameLayout(r15);
        r16.setLayoutParams(Util.createLayoutParams(-1, Util.dpToPx(300.0f, r10)));
        FrameLayout r17 = new FrameLayout(r15);
        FrameLayout.LayoutParams r18 = Util.createMatchParams();
        r18.setMargins(0, r13, 0, 0);
        r17.setLayoutParams(r18);
        r17.setBackgroundColor(Color.argb(100, 0, 0, 0));
        r16.addView(r17);
        this.mSpringSelectorSpinner = new Spinner(r15, 0);
        FrameLayout.LayoutParams r19 = Util.createMatchWrapParams();
        r19.gravity = 48;
        r19.setMargins(r12, r12, r12, 0);
        this.mSpringSelectorSpinner.setLayoutParams(r19);
        r17.addView(this.mSpringSelectorSpinner);
        LinearLayout r20 = new LinearLayout(r15);
        FrameLayout.LayoutParams r21 = Util.createMatchWrapParams();
        r21.setMargins(0, 0, 0, Util.dpToPx(80.0f, r10));
        r21.gravity = 80;
        r20.setLayoutParams(r21);
        r20.setOrientation(1);
        r17.addView(r20);
        LinearLayout r22 = new LinearLayout(r15);
        FrameLayout.LayoutParams r110 = Util.createMatchWrapParams();
        r110.setMargins(r12, r12, r12, r13);
        r22.setPadding(r12, r12, r12, r12);
        r22.setLayoutParams(r110);
        r22.setOrientation(0);
        r20.addView(r22);
        SeekBar r111 = new SeekBar(r15);
        this.mTensionSeekBar = r111;
        r111.setLayoutParams(r14);
        r22.addView(this.mTensionSeekBar);
        TextView r112 = new TextView(getContext());
        this.mTensionLabel = r112;
        r112.setTextColor(this.mTextColor);
        FrameLayout.LayoutParams r113 = Util.createLayoutParams(Util.dpToPx(MAX_FRICTION, r10), -1);
        this.mTensionLabel.setGravity(19);
        this.mTensionLabel.setLayoutParams(r113);
        this.mTensionLabel.setMaxLines(1);
        r22.addView(this.mTensionLabel);
        LinearLayout r23 = new LinearLayout(r15);
        FrameLayout.LayoutParams r114 = Util.createMatchWrapParams();
        r114.setMargins(r12, r12, r12, r13);
        r23.setPadding(r12, r12, r12, r12);
        r23.setLayoutParams(r114);
        r23.setOrientation(0);
        r20.addView(r23);
        SeekBar r24 = new SeekBar(r15);
        this.mFrictionSeekBar = r24;
        r24.setLayoutParams(r14);
        r23.addView(this.mFrictionSeekBar);
        TextView r25 = new TextView(getContext());
        this.mFrictionLabel = r25;
        r25.setTextColor(this.mTextColor);
        FrameLayout.LayoutParams r26 = Util.createLayoutParams(Util.dpToPx(MAX_FRICTION, r10), -1);
        this.mFrictionLabel.setGravity(19);
        this.mFrictionLabel.setLayoutParams(r26);
        this.mFrictionLabel.setMaxLines(1);
        r23.addView(this.mFrictionLabel);
        View r27 = new View(r15);
        FrameLayout.LayoutParams r115 = Util.createLayoutParams(Util.dpToPx(60.0f, r10), Util.dpToPx(40.0f, r10));
        r115.gravity = 49;
        r27.setLayoutParams(r115);
        r27.setOnTouchListener(new OnNubTouchListener(this, null));
        r27.setBackgroundColor(Color.argb(PrivateKeyType.INVALID, 0, 164, 209));
        r16.addView(r27);
        return r16;
    }

    private void togglePosition() {
        double r10 = this.mRevealerSpring.getEndValue();
        Spring r11 = this.mRevealerSpring;
        double r12 = 1.0d;
        if (r10 != 1.0d) goto L5;
        r12 = 0.0d;
    L5:
        r11.setEndValue(r12);
    }

    private void updateSeekBarsForSpringConfig(SpringConfig r10) {
        int r11 = Math.round(((((float) OrigamiValueConverter.origamiValueFromTension(r10.tension)) - 0.0f) * 100000.0f) / MAX_TENSION);
        int r12 = Math.round(((((float) OrigamiValueConverter.origamiValueFromFriction(r10.friction)) - 0.0f) * 100000.0f) / MAX_FRICTION);
        this.mTensionSeekBar.setProgress(r11);
        this.mFrictionSeekBar.setProgress(r12);
    }

    public void destroy() {
        ViewGroup r10 = (ViewGroup) getParent();
        if (r10 == null) goto L5;
        r10.removeView(this);
    L5:
        this.mRevealerSpring.destroy();
    }

    public void refreshSpringConfigurations() {
        Map<SpringConfig, String> r10 = this.springConfigRegistry.getAllSpringConfig();
        this.spinnerAdapter.clear();
        this.mSpringConfigs.clear();
        Iterator<Map.Entry<SpringConfig, String>> r11 = r10.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L9;
        Map.Entry<SpringConfig, String> r12 = r11.next();
        if (r12.getKey() == SpringConfig.defaultConfig) goto L4;
        this.mSpringConfigs.add(r12.getKey());
        this.spinnerAdapter.add(r12.getValue());
        goto L4
    L9:
        this.mSpringConfigs.add(SpringConfig.defaultConfig);
        this.spinnerAdapter.add(r10.get(SpringConfig.defaultConfig));
        this.spinnerAdapter.notifyDataSetChanged();
        if (this.mSpringConfigs.size() <= 0) goto L18;
        this.mSpringSelectorSpinner.setSelection(0);
        return;
    }

    public SpringConfiguratorView(Context r10, AttributeSet r11) {
        this(r10, r11, 0);
    }

    @TargetApi(11)
    public SpringConfiguratorView(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.mSpringConfigs = new ArrayList();
        this.mTextColor = Color.argb(PrivateKeyType.INVALID, 225, 225, 225);
        SpringSystem r13 = SpringSystem.create();
        this.springConfigRegistry = SpringConfigRegistry.getInstance();
        SpinnerAdapter r14 = new SpinnerAdapter(this, r10);
        this.spinnerAdapter = r14;
        Resources r15 = getResources();
        this.mRevealPx = Util.dpToPx(40.0f, r15);
        float r16 = Util.dpToPx(280.0f, r15);
        this.mStashPx = r16;
        Spring r17 = r13.createSpring();
        this.mRevealerSpring = r17;
        AnonymousClass1 r18 = null;
        r17.setCurrentValue(1.0d).setEndValue(1.0d).addListener(new RevealerSpringListener(this, r18));
        addView(generateHierarchy(r10));
        SeekbarListener r19 = new SeekbarListener(this, r18);
        this.mTensionSeekBar.setMax(MAX_SEEKBAR_VAL);
        this.mTensionSeekBar.setOnSeekBarChangeListener(r19);
        this.mFrictionSeekBar.setMax(MAX_SEEKBAR_VAL);
        this.mFrictionSeekBar.setOnSeekBarChangeListener(r19);
        this.mSpringSelectorSpinner.setAdapter(r14);
        this.mSpringSelectorSpinner.setOnItemSelectedListener(new SpringSelectedListener(this, r18));
        refreshSpringConfigurations();
        setTranslationY(r16);
    }
}
