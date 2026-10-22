package p5;

import android.net.NetworkRequest;
import androidx.room.y;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Set;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b extends y {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f9715d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(androidx.room.u uVar, int i) {
        super(uVar);
        this.f9715d = i;
    }

    @Override // androidx.room.y
    public final String b() {
        switch (this.f9715d) {
            case 0:
                return "INSERT OR IGNORE INTO `Dependency` (`work_spec_id`,`prerequisite_id`) VALUES (?,?)";
            case 1:
                return "INSERT OR REPLACE INTO `Preference` (`key`,`long_value`) VALUES (?,?)";
            case 2:
                return "INSERT OR REPLACE INTO `SystemIdInfo` (`work_spec_id`,`generation`,`system_id`) VALUES (?,?,?)";
            case 3:
                return "INSERT OR IGNORE INTO `WorkName` (`name`,`work_spec_id`) VALUES (?,?)";
            case 4:
                return "INSERT OR REPLACE INTO `WorkProgress` (`work_spec_id`,`progress`) VALUES (?,?)";
            case 5:
                return "INSERT OR IGNORE INTO `WorkSpec` (`id`,`state`,`worker_class_name`,`input_merger_class_name`,`input`,`output`,`initial_delay`,`interval_duration`,`flex_duration`,`run_attempt_count`,`backoff_policy`,`backoff_delay_duration`,`last_enqueue_time`,`minimum_retention_duration`,`schedule_requested_at`,`run_in_foreground`,`out_of_quota_policy`,`period_count`,`generation`,`next_schedule_time_override`,`next_schedule_time_override_generation`,`stop_reason`,`trace_tag`,`required_network_type`,`required_network_request`,`requires_charging`,`requires_device_idle`,`requires_battery_not_low`,`requires_storage_not_low`,`trigger_content_update_delay`,`trigger_max_content_delay`,`content_uri_triggers`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            default:
                return "INSERT OR IGNORE INTO `WorkTag` (`tag`,`work_spec_id`) VALUES (?,?)";
        }
    }

    public final void d(z4.j jVar, Object obj) throws IOException {
        int i;
        int i3;
        byte[] byteArray;
        byte[] byteArray2;
        int i10 = 3;
        switch (this.f9715d) {
            case 0:
                a aVar = (a) obj;
                jVar.h(1, aVar.f9713a);
                jVar.h(2, aVar.f9714b);
                return;
            case 1:
                d dVar = (d) obj;
                jVar.h(1, dVar.f9719a);
                jVar.c(2, dVar.f9720b.longValue());
                return;
            case 2:
                jVar.h(1, ((g) obj).f9726a);
                jVar.c(2, r13.f9727b);
                jVar.c(3, r13.f9728c);
                return;
            case 3:
                k kVar = (k) obj;
                jVar.h(1, kVar.f9736a);
                jVar.h(2, kVar.f9737b);
                return;
            case 4:
                throw new ClassCastException();
            case 5:
                p pVar = (p) obj;
                jVar.h(1, pVar.f9764a);
                jVar.c(2, a.a.W(pVar.f9765b));
                jVar.h(3, pVar.f9766c);
                jVar.h(4, pVar.f9767d);
                g5.h hVar = pVar.f9768e;
                g5.h hVar2 = g5.h.f4318b;
                jVar.s(5, ac.a.c0(hVar));
                jVar.s(6, ac.a.c0(pVar.f9769f));
                jVar.c(7, pVar.f9770g);
                jVar.c(8, pVar.f9771h);
                jVar.c(9, pVar.i);
                jVar.c(10, pVar.f9773k);
                int i11 = pVar.f9774l;
                if (i11 == 0) {
                    throw null;
                }
                int iC = s.f.c(i11);
                if (iC == 0) {
                    i = 0;
                } else {
                    if (iC != 1) {
                        g5.f.a();
                        return;
                    }
                    i = 1;
                }
                jVar.c(11, i);
                jVar.c(12, pVar.f9775m);
                jVar.c(13, pVar.f9776n);
                jVar.c(14, pVar.f9777o);
                jVar.c(15, pVar.f9778p);
                jVar.c(16, pVar.f9779q ? 1L : 0L);
                int i12 = pVar.f9780r;
                if (i12 == 0) {
                    throw null;
                }
                int iC2 = s.f.c(i12);
                if (iC2 == 0) {
                    i3 = 0;
                } else {
                    if (iC2 != 1) {
                        g5.f.a();
                        return;
                    }
                    i3 = 1;
                }
                jVar.c(17, i3);
                jVar.c(18, pVar.f9781s);
                jVar.c(19, pVar.f9782t);
                jVar.c(20, pVar.f9783u);
                jVar.c(21, pVar.f9784v);
                jVar.c(22, pVar.f9785w);
                String str = pVar.f9786x;
                if (str == null) {
                    jVar.B(23);
                } else {
                    jVar.h(23, str);
                }
                g5.d dVar2 = pVar.f9772j;
                int i13 = dVar2.f4287a;
                if (i13 == 0) {
                    throw null;
                }
                int iC3 = s.f.c(i13);
                if (iC3 == 0) {
                    i10 = 0;
                } else if (iC3 == 1) {
                    i10 = 1;
                } else if (iC3 == 2) {
                    i10 = 2;
                } else if (iC3 != 3) {
                    if (iC3 == 4) {
                        i10 = 4;
                    } else if (i13 == 6) {
                        i10 = 5;
                    } else {
                        od.f.m("Could not convert ", androidx.activity.b.y(i13), " to int");
                        i10 = 0;
                    }
                }
                jVar.c(24, i10);
                q5.d dVar3 = dVar2.f4288b;
                dVar3.getClass();
                NetworkRequest networkRequest = (NetworkRequest) dVar3.f10084a;
                if (networkRequest == null) {
                    byteArray = new byte[0];
                } else {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                        try {
                            int[] transportTypes = networkRequest.getTransportTypes();
                            transportTypes.getClass();
                            int[] capabilities = networkRequest.getCapabilities();
                            capabilities.getClass();
                            objectOutputStream.writeInt(transportTypes.length);
                            for (int i14 : transportTypes) {
                                objectOutputStream.writeInt(i14);
                            }
                            objectOutputStream.writeInt(capabilities.length);
                            for (int i15 : capabilities) {
                                objectOutputStream.writeInt(i15);
                            }
                            objectOutputStream.close();
                            byteArrayOutputStream.close();
                            byteArray = byteArrayOutputStream.toByteArray();
                            byteArray.getClass();
                        } finally {
                        }
                    } finally {
                    }
                }
                jVar.s(25, byteArray);
                jVar.c(26, dVar2.f4289c ? 1L : 0L);
                jVar.c(27, dVar2.f4290d ? 1L : 0L);
                jVar.c(28, dVar2.f4291e ? 1L : 0L);
                jVar.c(29, dVar2.f4292f ? 1L : 0L);
                jVar.c(30, dVar2.f4293g);
                jVar.c(31, dVar2.f4294h);
                Set<g5.c> set = dVar2.i;
                set.getClass();
                if (set.isEmpty()) {
                    byteArray2 = new byte[0];
                } else {
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                    try {
                        ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(byteArrayOutputStream2);
                        try {
                            objectOutputStream2.writeInt(set.size());
                            for (g5.c cVar : set) {
                                objectOutputStream2.writeUTF(cVar.f4282a.toString());
                                objectOutputStream2.writeBoolean(cVar.f4283b);
                            }
                            objectOutputStream2.close();
                            byteArrayOutputStream2.close();
                            byteArray2 = byteArrayOutputStream2.toByteArray();
                            byteArray2.getClass();
                        } finally {
                        }
                    } finally {
                    }
                }
                jVar.s(32, byteArray2);
                return;
            default:
                t tVar = (t) obj;
                jVar.h(1, tVar.f9804a);
                jVar.h(2, tVar.f9805b);
                return;
        }
    }

    public final void e(Object obj) {
        z4.j jVarA = a();
        try {
            d(jVarA, obj);
            jVarA.f16409f.executeInsert();
        } finally {
            c(jVarA);
        }
    }
}
