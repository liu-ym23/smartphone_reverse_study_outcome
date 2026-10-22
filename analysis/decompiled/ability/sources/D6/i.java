package D6;

import H4.r;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.provider.Settings;
import android.util.Log;
import com.stepos.ability.voicewakeup.setting.WakeupWordSelectionActivity;
import com.stepos.widget.glass.StepOSGlassImageButton;
import g4.C1459f;
import j9.t;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import z7.RunnableC2181b;

/* loaded from: classes3.dex */
public final /* synthetic */ class i implements S7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f385a;
    public final /* synthetic */ Object b;

    public /* synthetic */ i(Object obj, int i) {
        this.f385a = i;
        this.b = obj;
    }

    @Override // S7.a
    public final Object invoke() throws Throwable {
        File filesDir;
        int i = this.f385a;
        int i6 = 1;
        Object obj = this.b;
        switch (i) {
            case 0:
                StepOSGlassImageButton stepOSGlassImageButton = (StepOSGlassImageButton) obj;
                int i10 = StepOSGlassImageButton.f4106q;
                stepOSGlassImageButton.a();
                stepOSGlassImageButton.b();
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                int i11 = WakeupWordSelectionActivity.f;
                Intent intent = ((WakeupWordSelectionActivity) obj).getIntent();
                if (intent == null || (r8 = intent.getStringExtra("extra_entry_source")) == null) {
                }
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
            case 10:
                break;
            case 11:
                break;
            case 12:
                break;
            case 13:
                break;
            case 14:
                break;
            case 15:
                break;
            case 16:
                break;
            case 17:
                break;
            case 18:
                break;
            case 19:
                S7.a aVar = (S7.a) obj;
                E4.e eVar = com.stepos.ability.voicewakeup.service.l.o;
                if (eVar != null && (filesDir = eVar.f475a.getFilesDir()) != null) {
                    File[] fileArrListFiles = filesDir.listFiles(new E4.c(1));
                    if (fileArrListFiles != null) {
                        for (File file : fileArrListFiles) {
                            try {
                                file.delete();
                            } catch (Throwable th) {
                                kotlin.b.a(th);
                            }
                        }
                    }
                    File file2 = new File(filesDir, "user_wakeup.udm");
                    if (file2.exists()) {
                        try {
                            file2.delete();
                        } catch (Throwable th2) {
                            kotlin.b.a(th2);
                        }
                    }
                }
                Context context = com.stepos.ability.voicewakeup.service.l.n;
                if (context != null) {
                    Log.i("WakeupWordStorage", "clearAll");
                    SharedPreferences.Editor editorEdit = context.getApplicationContext().getSharedPreferences("voice_wakeup_active_word", 0).edit();
                    Set<String> setKeySet = context.getApplicationContext().getSharedPreferences("voice_wakeup_active_word", 0).getAll().keySet();
                    ArrayList arrayList = new ArrayList();
                    for (Object obj2 : setKeySet) {
                        String str = (String) obj2;
                        kotlin.jvm.internal.k.c(str);
                        if (t.e0(str, "keyphrase_", false)) {
                            arrayList.add(obj2);
                        }
                    }
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        editorEdit.remove((String) it.next());
                    }
                    editorEdit.remove("trained_ids");
                    editorEdit.apply();
                    Settings.Global.putInt(context.getContentResolver(), "voice_wakeup_enabled", 0);
                }
                com.stepos.ability.voicewakeup.service.l lVar = com.stepos.ability.voicewakeup.service.l.f3333a;
                com.stepos.ability.voicewakeup.service.l.v(false);
                com.stepos.ability.voicewakeup.service.l.m();
                if (aVar != null) {
                    com.stepos.ability.voicewakeup.service.l.g.invoke(new r(4, aVar));
                }
                break;
            case 20:
                break;
            case 21:
                break;
            case 22:
                break;
            case 23:
                break;
            case 24:
                break;
            case 25:
                com.zyql.agentfront.sdk.client.b bVar = (com.zyql.agentfront.sdk.client.b) obj;
                bVar.e(new com.zyql.agentfront.sdk.client.a(bVar, i6));
                break;
            case 26:
                break;
            case 27:
                break;
            case 28:
                ((RunnableC2181b) obj).run();
                break;
            default:
                C1459f c1459f = (C1459f) obj;
                long jMin = 1000;
                while (!c1459f.c) {
                    try {
                        Thread.sleep(jMin);
                    } catch (InterruptedException unused) {
                    }
                    if (c1459f.c || c1459f.a()) {
                        break;
                    } else {
                        jMin = Math.min(jMin * 2, 60000L);
                    }
                }
                break;
        }
        return C7.r.f317a;
    }
}
