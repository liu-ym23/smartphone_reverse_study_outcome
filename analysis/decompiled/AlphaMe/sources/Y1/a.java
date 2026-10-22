package Y1;

import B0.g;
import a2.AbstractC0155a;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.appcompat.app.o;
import androidx.appcompat.widget.C0238z;
import b2.C0366a;
import c2.AbstractC0392b;
import f1.AbstractC0557a;
import f2.b;
import g2.AbstractC0576a;
import java.util.Map;
import net.zetetic.database.sqlcipher.SQLiteDatabase;

/* loaded from: classes.dex */
public final class a extends AbstractC0576a {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f2119b;

    /* renamed from: c, reason: collision with root package name */
    public final String f2120c;

    public a(int i4) {
        this.f2119b = i4;
        switch (i4) {
            case 1:
                this.f2120c = a.class.getSimpleName();
                break;
            case 2:
                this.f2120c = a.class.getSimpleName();
                break;
            case 3:
                this.f2120c = a.class.getSimpleName();
                break;
            case 4:
                this.f2120c = a.class.getSimpleName();
                break;
            case 5:
                this.f2120c = a.class.getSimpleName();
                break;
            case 6:
                this.f2120c = a.class.getSimpleName();
                break;
            case 7:
                this.f2120c = a.class.getSimpleName();
                break;
            default:
                this.f2120c = a.class.getSimpleName();
                break;
        }
    }

    @Override // g2.AbstractC0576a
    public final String a() {
        switch (this.f2119b) {
            case 0:
                return "message";
            case 1:
                return "notification_arrived";
            case 2:
                return "private";
            case 3:
                return "push_status";
            case 4:
                return "register_status";
            case 5:
                return "sub_alias_status";
            case 6:
                return "sub_tags_status";
            default:
                return "un_register_status";
        }
    }

    public final f2.a c(Context context, Intent intent) {
        int i4 = this.f2119b;
        f2.a aVar = null;
        String str = this.f2120c;
        switch (i4) {
            case 0:
                AbstractC0155a.b(str, "getMessage start");
                try {
                    f2.a aVar2 = new f2.a();
                    aVar2.f12527a = intent.getStringExtra("extra_app_push_task_Id");
                    aVar2.f12528b = intent.getStringExtra("extra_app_push_seq_Id");
                    aVar2.f12538l = intent.getStringExtra("message");
                    aVar2.f12536j = intent.getStringExtra("extra_app_push_task_timestamp");
                    aVar2.f12541o = intent.getStringExtra("msg_es");
                    aVar2.f12531e = context.getPackageName();
                    AbstractC0155a.b(str, "getMessage success");
                    break;
                } catch (Exception e4) {
                    AbstractC0155a.c(str, "getMessage error, " + e4.getMessage());
                    return null;
                }
            case 1:
                AbstractC0155a.b(str, "getMessage start");
                try {
                    String stringExtra = intent.getStringExtra("messageValue");
                    if (TextUtils.isEmpty(stringExtra)) {
                        AbstractC0155a.c(str, "getMessage fail, messageValue is empty");
                    } else {
                        f2.a aVarA = f2.a.a(stringExtra);
                        if (aVarA == null) {
                            AbstractC0155a.c(str, "getMessage fail, messageData is null");
                        } else {
                            AbstractC0155a.b(str, "getMessage success");
                            aVar = aVarA;
                        }
                    }
                    break;
                } catch (Exception e5) {
                    AbstractC0155a.c(str, "getMessage error, " + e5.getMessage());
                    break;
                }
            default:
                AbstractC0155a.b(str, "getMessage start");
                try {
                    String stringExtra2 = intent.getStringExtra("messageValue");
                    if (TextUtils.isEmpty(stringExtra2)) {
                        AbstractC0155a.c(str, "getMessage fail, messageValue is empty");
                    } else {
                        f2.a aVarA2 = f2.a.a(stringExtra2);
                        if (aVarA2 == null) {
                            AbstractC0155a.c(str, "getMessage fail, messageData is null");
                        } else {
                            AbstractC0155a.b(str, "getMessage success");
                            aVar = aVarA2;
                        }
                    }
                    break;
                } catch (Exception e6) {
                    AbstractC0155a.c(str, "getMessage error, " + e6.getMessage());
                    break;
                }
        }
        return aVar;
        return aVar;
    }

    public final void d(Context context, f2.a aVar, U1.a aVar2) {
        Intent launchIntentForPackage;
        Intent intent;
        Map map;
        switch (this.f2119b) {
            case 0:
                if (aVar != null) {
                    AbstractC0557a.Q(context, "rpe", aVar.f12531e, aVar.f12527a, aVar.f12528b, aVar.f12536j);
                    if (!TextUtils.isEmpty(aVar.f12538l)) {
                        String str = aVar.f12527a;
                        String str2 = aVar.f12528b;
                        String str3 = aVar.f12536j;
                        X1.a aVar3 = new X1.a();
                        if (TextUtils.isEmpty(str)) {
                            str = "";
                        }
                        aVar3.f2107a = str;
                        if (TextUtils.isEmpty(str2)) {
                            str2 = "";
                        }
                        aVar3.f2108b = str2;
                        aVar3.f2109c = TextUtils.isEmpty(str3) ? "" : str3;
                        aVar2.onMessage(context, aVar.f12538l, aVar3.a());
                        break;
                    }
                }
                break;
            case 1:
                if (aVar != null) {
                    aVar2.onNotificationArrived(context, C0366a.a(aVar, "com.stepos.appstore".equalsIgnoreCase(context.getPackageName())));
                    break;
                }
                break;
            default:
                if (aVar != null) {
                    AbstractC0557a.Q(context, "cpm", aVar.f12531e, aVar.f12527a, aVar.f12528b, aVar.f12536j);
                    String str4 = aVar.f12535i;
                    if (TextUtils.isEmpty(str4)) {
                        str4 = aVar.f12531e;
                    }
                    String strM = g.m("openClassName is ", str4);
                    String str5 = this.f2120c;
                    AbstractC0155a.b(str5, strM);
                    int i4 = aVar.f12532f;
                    if (i4 == 0) {
                        launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str4);
                        if (launchIntentForPackage != null && (map = aVar.f12537k) != null) {
                            for (Map.Entry entry : map.entrySet()) {
                                AbstractC0155a.b(str5, " launcher activity key " + ((String) entry.getKey()) + " value " + ((String) entry.getValue()));
                                if (!TextUtils.isEmpty((CharSequence) entry.getKey()) && !TextUtils.isEmpty((CharSequence) entry.getValue())) {
                                    launchIntentForPackage.putExtra((String) entry.getKey(), (String) entry.getValue());
                                }
                            }
                        }
                    } else {
                        if (1 == i4) {
                            intent = new Intent();
                            Map map2 = aVar.f12537k;
                            if (map2 != null) {
                                for (Map.Entry entry2 : map2.entrySet()) {
                                    AbstractC0155a.b(str5, " key " + ((String) entry2.getKey()) + " value " + ((String) entry2.getValue()));
                                    if (!TextUtils.isEmpty((CharSequence) entry2.getKey()) && !TextUtils.isEmpty((CharSequence) entry2.getValue())) {
                                        intent.putExtra((String) entry2.getKey(), (String) entry2.getValue());
                                    }
                                }
                            }
                            intent.setClassName(str4, aVar.f12533g);
                            AbstractC0155a.b(str5, intent.toUri(1));
                        } else if (2 == i4) {
                            intent = new Intent("android.intent.action.VIEW", Uri.parse(aVar.f12534h));
                            String str6 = aVar.f12535i;
                            if (!TextUtils.isEmpty(str6)) {
                                intent.setPackage(str6);
                                AbstractC0155a.b(str5, "set uri package " + str6);
                            }
                        } else {
                            if (3 == i4) {
                                AbstractC0155a.b(str5, "CLICK_TYPE_SELF_DEFINE_ACTION");
                            }
                            launchIntentForPackage = null;
                        }
                        launchIntentForPackage = intent;
                    }
                    if (launchIntentForPackage != null) {
                        String str7 = aVar.f12527a;
                        X1.a aVar4 = new X1.a();
                        if (TextUtils.isEmpty(str7)) {
                            str7 = "";
                        }
                        aVar4.f2107a = str7;
                        aVar4.f2108b = !TextUtils.isEmpty(null) ? null : "";
                        aVar4.f2109c = TextUtils.isEmpty(null) ? "" : null;
                        launchIntentForPackage.putExtra("platform_extra", aVar4.a());
                    }
                    if (launchIntentForPackage != null) {
                        launchIntentForPackage.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                        try {
                            context.startActivity(launchIntentForPackage);
                        } catch (Exception e4) {
                            AbstractC0155a.c(str5, "Click message StartActivity error " + e4.getMessage());
                        }
                    }
                    if (!TextUtils.isEmpty(aVar.f12529c) && !TextUtils.isEmpty(aVar.f12530d)) {
                        aVar2.onNotificationClicked(context, C0366a.a(aVar, false));
                    }
                    b bVar = aVar.f12539m;
                    if (bVar != null) {
                        AbstractC0155a.c("MessageNotificationHelper", "clear notifyId " + bVar.f12542a + " notifyKey " + bVar.f12543b);
                        int i5 = 13;
                        if (TextUtils.isEmpty(bVar.f12543b)) {
                            C0238z c0238z = V1.a.f1932a;
                            String str8 = aVar.f12531e;
                            int[] iArr = {bVar.f12542a};
                            W1.a aVar5 = (W1.a) c0238z.f3217f;
                            aVar5.f1988e = 1;
                            aVar5.f1987d = iArr;
                            aVar5.f1989f = null;
                            aVar5.f1990g = str8;
                            AbstractC0392b.f4467a.execute(new o(i5, aVar5, context));
                            break;
                        } else {
                            C0238z c0238z2 = V1.a.f1932a;
                            String str9 = aVar.f12531e;
                            String str10 = bVar.f12543b;
                            W1.a aVar6 = (W1.a) c0238z2.f3217f;
                            aVar6.f1988e = 2;
                            aVar6.f1987d = null;
                            aVar6.f1989f = str10;
                            aVar6.f1990g = str9;
                            AbstractC0392b.f4467a.execute(new o(i5, aVar6, context));
                            break;
                        }
                    }
                }
                break;
        }
    }
}
