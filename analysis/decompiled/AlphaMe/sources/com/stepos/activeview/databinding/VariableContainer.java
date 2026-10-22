package com.stepos.activeview.databinding;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Point;
import android.os.Handler;
import android.view.Display;
import android.view.WindowManager;
import com.stepos.activeview.databinding.interfaces.IActiveViewApplying;
import com.stepos.activeview.databinding.interfaces.OnVariableChangedListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;
import net.sourceforge.jeval.EvaluationConstants;
import net.sourceforge.jeval.EvaluationException;
import net.sourceforge.jeval.Evaluator;

/* loaded from: classes.dex */
public class VariableContainer implements IActiveViewApplying {
    private boolean mApplying;
    private Context mContext;
    private boolean mRegisterBroadcast;
    private BroadcastReceiver mTimeTickReceiver;
    private Handler mTimeHandler = new Handler();
    private Runnable mTimeUpdateRunnable = new Runnable() { // from class: com.stepos.activeview.databinding.VariableContainer.1
        @Override // java.lang.Runnable
        public void run() throws IllegalArgumentException {
            VariableContainer.this.mCalendar.setTimeInMillis(System.currentTimeMillis());
            VariableContainer.this.mTimeHandler.postDelayed(VariableContainer.this.mTimeUpdateRunnable, 1000L);
            VariableContainer variableContainer = VariableContainer.this;
            variableContainer.updateSystemValue(Constants.DEF_VAR_HOUR12, String.valueOf(variableContainer.mCalendar.get(10)));
            VariableContainer variableContainer2 = VariableContainer.this;
            variableContainer2.updateSystemValue(Constants.DEF_VAR_HOUR24, String.valueOf(variableContainer2.mCalendar.get(11)));
            VariableContainer variableContainer3 = VariableContainer.this;
            variableContainer3.updateSystemValue(Constants.DEF_VAR_MINUTE, String.valueOf(variableContainer3.mCalendar.get(12)));
            VariableContainer variableContainer4 = VariableContainer.this;
            variableContainer4.updateSystemValue(Constants.DEF_VAR_SECOND, String.valueOf(variableContainer4.mCalendar.get(13)));
        }
    };
    private Evaluator mEvaluator = new Evaluator();
    private List<Variable> mVariables = new ArrayList();
    private Calendar mCalendar = Calendar.getInstance();
    protected Set<String> mListeningVariables = new HashSet();

    public VariableContainer(Context context) throws IllegalArgumentException {
        this.mContext = context;
        addSystemVariable();
    }

    private void addSystemVariable() throws IllegalArgumentException {
        Display defaultDisplay = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        addVariable(Constants.DEF_VAR_SCREEN_WIDTH, String.valueOf(point.x), 1, true, true, String.valueOf(point.x));
        addVariable(Constants.DEF_VAR_SCREEN_HEIGHT, String.valueOf(point.y), 1, true, true, String.valueOf(point.y));
        this.mCalendar.setTimeInMillis(System.currentTimeMillis());
        dateTimeUpdate(true);
        addVariable(Constants.DEF_VAR_BATTERY_LEVEL, "100", 1, true, false, null);
        addVariable(Constants.DEF_VAR_BATTERY_STATE, "'namol'", 0, true, false, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void batteryUpdate(Intent intent) throws IllegalArgumentException {
        int intExtra = intent.getIntExtra("level", -1);
        int intExtra2 = intent.getIntExtra("status", -1);
        updateExpression(Constants.DEF_VAR_BATTERY_LEVEL, String.valueOf(intExtra));
        if (intExtra2 == 5) {
            updateSystemValue(Constants.DEF_VAR_BATTERY_STATE, "'FULL'");
            return;
        }
        if (intExtra2 == 2) {
            updateSystemValue(Constants.DEF_VAR_BATTERY_STATE, "'CHARGING'");
            return;
        }
        if (intExtra2 == 3) {
            updateSystemValue(Constants.DEF_VAR_BATTERY_STATE, "'DISCHARGING'");
        } else if (intExtra2 == 4) {
            updateSystemValue(Constants.DEF_VAR_BATTERY_STATE, "'NOT_CHARGING'");
        } else {
            updateSystemValue(Constants.DEF_VAR_BATTERY_STATE, "'UNKOWN'");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dateTimeUpdate(boolean z4) throws IllegalArgumentException {
        String strValueOf = String.valueOf(this.mCalendar.get(13));
        String strValueOf2 = String.valueOf(this.mCalendar.get(12));
        String strValueOf3 = String.valueOf(this.mCalendar.get(10));
        String strValueOf4 = String.valueOf(this.mCalendar.get(11));
        String strValueOf5 = String.valueOf(this.mCalendar.get(1));
        String strValueOf6 = String.valueOf(this.mCalendar.get(2) + 1);
        String strValueOf7 = String.valueOf(this.mCalendar.get(5));
        String strValueOf8 = String.valueOf(this.mCalendar.get(7));
        if (!z4) {
            updateSystemValue("year", strValueOf5);
            updateSystemValue(Constants.DEF_VAR_MONTH, strValueOf6);
            updateSystemValue("date", strValueOf7);
            updateSystemValue(Constants.DEF_VAR_DATE_OF_WEEK, strValueOf8);
            this.mTimeHandler.removeCallbacksAndMessages(this.mTimeUpdateRunnable);
            this.mTimeHandler.post(this.mTimeUpdateRunnable);
            return;
        }
        addVariable("year", strValueOf5, 1, true, false, strValueOf5);
        addVariable(Constants.DEF_VAR_MONTH, strValueOf6, 1, true, false, strValueOf6);
        addVariable("date", strValueOf7, 1, true, false, strValueOf7);
        addVariable(Constants.DEF_VAR_DATE_OF_WEEK, strValueOf8, 1, true, false, strValueOf8);
        addVariable(Constants.DEF_VAR_HOUR12, strValueOf3, 1, true, false, strValueOf3);
        addVariable(Constants.DEF_VAR_HOUR24, strValueOf4, 1, true, false, strValueOf4);
        addVariable(Constants.DEF_VAR_MINUTE, strValueOf2, 1, true, false, strValueOf2);
        addVariable(Constants.DEF_VAR_SECOND, strValueOf, 1, true, false, strValueOf);
    }

    private void putVariable2Eva(String str, int i4, String str2) throws IllegalArgumentException {
        this.mEvaluator.putVariable(str, str2);
    }

    public void addVariable(String str, String str2, int i4, boolean z4, boolean z5, String str3) throws IllegalArgumentException {
        putVariable(new Variable(str, str2, i4, z4, z5, str3));
    }

    public String evaluate(String str) {
        if (str == null) {
            return null;
        }
        try {
            return this.mEvaluator.evaluate(str);
        } catch (EvaluationException unused) {
            return null;
        }
    }

    public List<Variable> getAllVariables() {
        return this.mVariables;
    }

    public Evaluator getEvaluator() {
        return this.mEvaluator;
    }

    public Variable getVariable(String str) {
        for (Variable variable : this.mVariables) {
            if (variable.name.equals(str)) {
                return variable;
            }
        }
        return null;
    }

    public String getVariableValue(String str) {
        Variable variable = getVariable(str);
        if (variable != null) {
            return variable.value;
        }
        return null;
    }

    public void putVariable(Variable variable) throws IllegalArgumentException {
        String str;
        String str2 = variable.name;
        if (str2 == null || str2.equals("") || getVariable(variable.name) != null) {
            return;
        }
        if (variable.value == null && (str = variable.expression) != null) {
            variable.value = evaluate(str);
        }
        if (variable.value != null) {
            this.mVariables.add(variable);
            putVariable2Eva(variable.name, variable.type, variable.value);
        }
    }

    public void registerListener(String str, OnVariableChangedListener onVariableChangedListener) {
        int iIndexOf = str.indexOf(EvaluationConstants.OPEN_VARIABLE);
        if (iIndexOf < 0) {
            return;
        }
        while (iIndexOf >= 0) {
            if (iIndexOf >= 0) {
                int iIndexOf2 = str.indexOf(EvaluationConstants.CLOSED_VARIABLE, iIndexOf + 1);
                if (iIndexOf2 <= iIndexOf) {
                    return;
                }
                String strSubstring = str.substring(EvaluationConstants.OPEN_VARIABLE.length() + iIndexOf, iIndexOf2);
                Variable variable = getVariable(strSubstring);
                if (variable != null) {
                    variable.registerVariableChangedListener(onVariableChangedListener);
                    this.mListeningVariables.add(strSubstring);
                }
                str = str.substring(iIndexOf2 + 1);
            }
            iIndexOf = str.indexOf(EvaluationConstants.OPEN_VARIABLE);
        }
    }

    public void registerReceiver() throws IllegalArgumentException {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.DATE_CHANGED");
        intentFilter.addAction("android.intent.action.TIME_SET");
        intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
        intentFilter.addAction("android.intent.action.TIME_TICK");
        intentFilter.addAction("android.intent.action.LOCALE_CHANGED");
        intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
        if (this.mTimeTickReceiver == null) {
            this.mTimeTickReceiver = new BroadcastReceiver() { // from class: com.stepos.activeview.databinding.VariableContainer.2
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) throws IllegalArgumentException {
                    if (intent.getAction().equals("android.intent.action.BATTERY_CHANGED")) {
                        VariableContainer.this.batteryUpdate(intent);
                    }
                    if (intent.getAction().equals("android.intent.action.TIMEZONE_CHANGED")) {
                        VariableContainer.this.mCalendar.setTimeZone(TimeZone.getDefault());
                    }
                    VariableContainer.this.mCalendar.setTimeInMillis(System.currentTimeMillis());
                    VariableContainer.this.dateTimeUpdate(false);
                }
            };
        }
        if (this.mRegisterBroadcast) {
            return;
        }
        batteryUpdate(this.mContext.registerReceiver(this.mTimeTickReceiver, intentFilter));
        this.mRegisterBroadcast = true;
    }

    @Override // com.stepos.activeview.databinding.interfaces.IActiveViewApplying
    public void startApplying() throws IllegalArgumentException {
        if (this.mApplying) {
            return;
        }
        Iterator<Variable> it = this.mVariables.iterator();
        while (it.hasNext()) {
            it.next().bind(this);
        }
        registerReceiver();
        this.mApplying = true;
    }

    @Override // com.stepos.activeview.databinding.interfaces.IActiveViewApplying
    public void stopApplying() {
        if (this.mApplying) {
            Iterator<Variable> it = this.mVariables.iterator();
            while (it.hasNext()) {
                it.next().unBind();
            }
            unRegisterReceiver();
            this.mTimeHandler.removeCallbacks(this.mTimeUpdateRunnable);
            this.mApplying = false;
        }
    }

    public void unRegisterReceiver() {
        if (this.mRegisterBroadcast) {
            this.mContext.unregisterReceiver(this.mTimeTickReceiver);
            this.mRegisterBroadcast = false;
        }
    }

    public void unregisterListener(OnVariableChangedListener onVariableChangedListener) {
        Iterator<String> it = this.mListeningVariables.iterator();
        while (it.hasNext()) {
            getVariable(it.next()).unregisterVariableChangedListener(onVariableChangedListener);
        }
    }

    public void updateExpression(String str, String str2) throws IllegalArgumentException {
        String strEvaluate;
        Variable variable = getVariable(str);
        if (variable == null || variable.isConst || (strEvaluate = evaluate(str2)) == null || strEvaluate.equals(variable.value)) {
            return;
        }
        variable.expression = str2;
        variable.value = strEvaluate;
        putVariable2Eva(str, variable.type, strEvaluate);
    }

    public void updateSystemValue(String str, String str2) throws IllegalArgumentException {
        Variable variable = getVariable(str);
        if (variable != null) {
            variable.setValue(str2);
        }
    }
}
