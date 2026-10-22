package com.stepos.alphame.predict;

import B0.g;
import android.database.Cursor;
import androidx.room.AbstractC0351g;
import com.stepos.alphame.ApplicationImpl;
import com.stepos.alphame.NotProguard;
import com.stepos.alphame.appinfo.AppInfoDbHelper;
import com.stepos.alphame.awareness.AwarenessDataItem;
import com.stepos.alphame.awareness.AwarenessDataSource;
import com.stepos.alphame.awareness.AwarenessStorable;
import com.stepos.alphame.engine.EngineBase;
import com.stepos.alphame.engine.EngineFunc;
import com.stepos.alphame.scene.QuickAppHelper;
import com.stepos.alphame.utils.AppUtils;
import com.stepos.alphame.utils.LocalConsts;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0005\u0013\u0014\u0015\u0016\u0017B\u0005¢\u0006\u0002\u0010\u0002J\u001f\u0010\u0003\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\bJ\u001f\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\bJ\u001f\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\bJ \u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\u0007J\u0018\u0010\u000f\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007H\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0014J\b\u0010\u0012\u001a\u00020\u0011H\u0014¨\u0006\u0018"}, d2 = {"Lcom/stepos/alphame/predict/PredictEngine;", "Lcom/stepos/alphame/engine/EngineBase;", "()V", LocalConsts.FUNC_GET_PREDICTION, "", "", "predictCnt", "", "(I)[Ljava/lang/String;", LocalConsts.FUNC_GET_PREDICTION3, LocalConsts.FUNC_GET_PREDICTION_WITH_USERID, LocalConsts.FUNC_GET_SCENE_FREQUENCY, "permissionID", "permissionValue", "day", "getSceneSelection", "onStart", "", "onStop", "Companion", "GetSceneFrequency", "Predict", "Predict3", "PredictWithUserId", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PredictEngine extends EngineBase {
    private static final int GAME_DISABLE = 3;
    private static final int GAME_VALUE_NORMAL = 0;
    private static final int PERMISSION_ID_GAME = 10;

    @NotNull
    public static final String TAG = "PredictEngine";

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final Lazy<PredictEngine> INSTANCE$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<PredictEngine>() { // from class: com.stepos.alphame.predict.PredictEngine$Companion$INSTANCE$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final PredictEngine invoke() {
            return new PredictEngine();
        }
    });

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/stepos/alphame/predict/PredictEngine$Companion;", "", "()V", "GAME_DISABLE", "", "GAME_VALUE_NORMAL", "INSTANCE", "Lcom/stepos/alphame/predict/PredictEngine;", "getINSTANCE", "()Lcom/stepos/alphame/predict/PredictEngine;", "INSTANCE$delegate", "Lkotlin/Lazy;", "PERMISSION_ID_GAME", "TAG", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final PredictEngine getINSTANCE() {
            return (PredictEngine) PredictEngine.INSTANCE$delegate.getValue();
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/stepos/alphame/predict/PredictEngine$GetSceneFrequency;", "Lcom/stepos/alphame/engine/EngineFunc;", "_owner", "Lcom/stepos/alphame/engine/EngineBase;", "(Lcom/stepos/alphame/engine/EngineBase;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class GetSceneFrequency extends EngineFunc {
        public GetSceneFrequency(@Nullable EngineBase engineBase) {
            super(engineBase);
            this.name = LocalConsts.FUNC_GET_SCENE_FREQUENCY;
            this.argsType = new byte[]{4, 4, 4};
            this.argsName = new String[]{"permissionID", "permissionValue", "day"};
            this.returnType = (byte) 4;
            this.annotation = new String[]{"获取应用预测列表", "@author lxh", "@return 获取指定场景在过去几天内的打开次数"};
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/stepos/alphame/predict/PredictEngine$Predict;", "Lcom/stepos/alphame/engine/EngineFunc;", "_owner", "Lcom/stepos/alphame/engine/EngineBase;", "(Lcom/stepos/alphame/engine/EngineBase;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Predict extends EngineFunc {
        public Predict(@Nullable EngineBase engineBase) {
            super(engineBase);
            this.name = LocalConsts.FUNC_GET_PREDICTION;
            this.argsType = new byte[]{4};
            this.argsName = new String[]{"predictCnt"};
            this.returnType = (byte) 9;
            this.annotation = new String[]{"获取应用预测列表", "@author lxh", "@return 获取指定个数的应用预测列表"};
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/stepos/alphame/predict/PredictEngine$Predict3;", "Lcom/stepos/alphame/engine/EngineFunc;", "_owner", "Lcom/stepos/alphame/engine/EngineBase;", "(Lcom/stepos/alphame/engine/EngineBase;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Predict3 extends EngineFunc {
        public Predict3(@Nullable EngineBase engineBase) {
            super(engineBase);
            this.name = LocalConsts.FUNC_GET_PREDICTION3;
            this.argsType = new byte[]{4};
            this.argsName = new String[]{"predictCnt"};
            this.returnType = (byte) 9;
            this.annotation = new String[]{"获取应用预测列表新接口，包含UserId和快应用", "@author lxh", "@return 获取指定个数的应用预测列表"};
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/stepos/alphame/predict/PredictEngine$PredictWithUserId;", "Lcom/stepos/alphame/engine/EngineFunc;", "_owner", "Lcom/stepos/alphame/engine/EngineBase;", "(Lcom/stepos/alphame/engine/EngineBase;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class PredictWithUserId extends EngineFunc {
        public PredictWithUserId(@Nullable EngineBase engineBase) {
            super(engineBase);
            this.name = LocalConsts.FUNC_GET_PREDICTION_WITH_USERID;
            this.argsType = new byte[]{4};
            this.argsName = new String[]{"predictCnt"};
            this.returnType = (byte) 9;
            this.annotation = new String[]{"获取应用预测列表新接口，包含UserId", "@author lxh", "@return 获取指定个数的应用预测列表"};
        }
    }

    private final String getSceneSelection(int permissionID, int permissionValue) {
        if (permissionID == 10 && permissionValue != 3) {
            return "scene = 3 and state = 10";
        }
        ArrayList<String> installedPkgs = AppUtils.getInstalledPkgs(ApplicationImpl.getApplication());
        Iterator<String> it = AppInfoDbHelper.getInstance().query(permissionID, permissionValue).iterator();
        String strP = "";
        while (it.hasNext()) {
            String next = it.next();
            if (installedPkgs.contains(next)) {
                strP = AbstractC0351g.p(strP, strP.length() == 0 ? g.n("'", next, "'") : g.n(",'", next, "'"));
            }
        }
        return strP.length() > 0 ? g.n("scene = 3 and data1 in (", strP, ")") : "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotProguard
    @Nullable
    public final String[] getPrediction(int predictCnt) {
        PredictManager predictManager = PredictManager.getInstance(ApplicationImpl.getApplication());
        List<String> listPredictApp = predictManager.predictApp(predictCnt, false, System.currentTimeMillis());
        if (listPredictApp == null || listPredictApp.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : listPredictApp) {
            Intrinsics.checkNotNull(str);
            if (StringsKt.c(str, AwarenessDataItem.USERID_SPLITTER)) {
                String pkgName = predictManager.formatPkgName(str);
                if (!arrayList.contains(pkgName)) {
                    Intrinsics.checkNotNull(pkgName);
                    arrayList.add(pkgName);
                }
            } else if (!QuickAppHelper.isQuickPrefix(str) && !arrayList.contains(str)) {
                arrayList.add(str);
            }
        }
        String[] strArr = new String[arrayList.size()];
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            strArr[i4] = arrayList.get(i4);
        }
        return strArr;
    }

    @NotProguard
    @Nullable
    public final String[] getPrediction3(int predictCnt) {
        List<String> listPredictApp = PredictManager.getInstance(ApplicationImpl.getApplication()).predictApp(predictCnt, false, System.currentTimeMillis());
        if (listPredictApp == null || listPredictApp.size() == 0) {
            return null;
        }
        String[] strArr = new String[listPredictApp.size()];
        int size = listPredictApp.size();
        for (int i4 = 0; i4 < size; i4++) {
            strArr[i4] = listPredictApp.get(i4);
        }
        return strArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotProguard
    @Nullable
    public final String[] getPredictionWithUserId(int predictCnt) {
        List<String> listPredictApp = PredictManager.getInstance(ApplicationImpl.getApplication()).predictApp(predictCnt + 10, false, System.currentTimeMillis());
        if (listPredictApp == null || listPredictApp.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : listPredictApp) {
            if (!QuickAppHelper.isQuickPrefix(str)) {
                Intrinsics.checkNotNull(str);
                arrayList.add(str);
            }
        }
        String[] strArr = new String[arrayList.size()];
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            strArr[i4] = arrayList.get(i4);
        }
        return strArr;
    }

    @NotProguard
    public final int getSceneFrequency(int permissionID, int permissionValue, int day) {
        long jCurrentTimeMillis = System.currentTimeMillis() - (day * 86400000);
        String sceneSelection = getSceneSelection(permissionID, permissionValue);
        if (sceneSelection.length() > 0) {
            AwarenessDataSource.getInstance().store(true);
            try {
                Cursor cursor = AwarenessStorable.getCursor(sceneSelection.concat(" and date > ? and data1 != ?"), new String[]{String.valueOf(jCurrentTimeMillis), ""}, null, null);
                try {
                    Cursor cursor2 = cursor;
                    count = cursor2 != null ? cursor2.getCount() : 0;
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(cursor, null);
                } finally {
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        return count;
    }

    @Override // com.stepos.alphame.engine.EngineBase
    public void onStart() {
        super.onStart();
        EngineBase.addFunc(new Predict(this));
        EngineBase.addFunc(new PredictWithUserId(this));
        EngineBase.addFunc(new Predict3(this));
        EngineBase.addFunc(new GetSceneFrequency(this));
    }

    @Override // com.stepos.alphame.engine.EngineBase
    public void onStop() {
        super.onStop();
    }
}
