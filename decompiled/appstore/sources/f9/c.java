package f9;

import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.toolbox.j;
import com.monitor.cloudmessage.callback.IAlogConsumer;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {

    public class a implements IAlogConsumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List f19542a;

        public a() {
        }

        @Override // com.monitor.cloudmessage.callback.IConsumerResultCallback
        public w9.b getConsumerResult() {
            List r10 = this.f19542a;
            if (r10 != null) goto L5;
        L7:
            boolean r11 = false;
        L8:
            j.a("CloudMessageHelper isSuccess " + r11);
            if (r11 == false) goto L11;
            String r12 = "";
        L13:
            return w9.b.a(r11, r12, null);
        L11:
            r12 = "alog file not get";
            goto L13
        L5:
            if (r10.size() <= 0) goto L7;
            r11 = true;
            goto L8
        }

        @Override // com.monitor.cloudmessage.callback.IAlogConsumer
        public List handleAlogData(long r10, long r11, JSONObject r12) {
            j.a("CloudMessageHelper  startTime   " + r10 + "  endTime " + r11);
            if (r10 >= r11) goto L11;
            re.a.g();
            Thread.sleep(1000);     // Catch: InterruptedException -> L7
        L9:
            this.f19542a = re.a.m(r10, r11);
            j.a("CloudMessageHelper  alogList:   " + this.f19542a);
        L7:
            e = move-exception;
            e.printStackTrace();
        L11:
            return this.f19542a;
        }
    }

    public static void a() {
        v9.a.r(BaseApplication.c());
        v9.a.v(new a());
    }
}
