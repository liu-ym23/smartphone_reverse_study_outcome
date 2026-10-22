package io.ktor.client.plugins.sse;

import Ua.C1060i;
import Ua.C1087w;
import Ua.InterfaceC1083u;
import androidx.exifinterface.media.ExifInterface;
import com.stepos.policy.sdk.config.PolicySdkConstants;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import io.ktor.client.HttpClient;
import io.ktor.client.HttpClientConfig;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.call.SavedHttpCall;
import io.ktor.client.call.SavedHttpResponse;
import io.ktor.client.plugins.HttpClientPluginKt;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.URLParserKt;
import io.ktor.util.AttributeKey;
import io.ktor.util.reflect.TypeInfo;
import kotlin.Metadata;
import p9.InterfaceC5074l;
import w9.C5757p;
import w9.InterfaceC5745d;
import w9.InterfaceC5755n;

@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\u001a)\u0010\u0005\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001aL\u0010\u0012\u001a\u00020\u000f*\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030\u0001H\u0086@¢\u0006\u0004\b\u0010\u0010\u0011\u001a~\u0010\u0012\u001a\u00020\u000f*\u00020\u00072\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030\u0001H\u0086@¢\u0006\u0004\b\u0019\u0010\u001a\u001aV\u0010\u0012\u001a\u00020\u000f*\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00132\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030\u0001H\u0086@¢\u0006\u0004\b\u001c\u0010\u001d\u001ap\u0010$\u001a\u00020\u0003*\u00020\u00072\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030\u00012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\"\u0010\u000e\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030 \u0012\u0006\u0012\u0004\u0018\u00010!0\u001fH\u0086@¢\u0006\u0004\b\"\u0010#\u001a¢\u0001\u0010$\u001a\u00020\u0003*\u00020\u00072\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\u0014\b\u0002\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030\u00012\"\u0010\u000e\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030 \u0012\u0006\u0012\u0004\u0018\u00010!0\u001fH\u0086@¢\u0006\u0004\b%\u0010&\u001az\u0010$\u001a\u00020\u0003*\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00132\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\u0014\b\u0002\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030\u00012\"\u0010\u000e\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030 \u0012\u0006\u0012\u0004\u0018\u00010!0\u001fH\u0086@¢\u0006\u0004\b'\u0010(\u001aL\u0010*\u001a\u00020\u000f*\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030\u0001H\u0086@¢\u0006\u0004\b)\u0010\u0011\u001a~\u0010*\u001a\u00020\u000f*\u00020\u00072\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030\u0001H\u0086@¢\u0006\u0004\b+\u0010\u001a\u001aV\u0010*\u001a\u00020\u000f*\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00132\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030\u0001H\u0086@¢\u0006\u0004\b,\u0010\u001d\u001ap\u0010.\u001a\u00020\u0003*\u00020\u00072\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030\u00012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\"\u0010\u000e\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030 \u0012\u0006\u0012\u0004\u0018\u00010!0\u001fH\u0086@¢\u0006\u0004\b-\u0010#\u001a¢\u0001\u0010.\u001a\u00020\u0003*\u00020\u00072\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00132\u0014\b\u0002\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030\u00012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\"\u0010\u000e\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030 \u0012\u0006\u0012\u0004\u0018\u00010!0\u001fH\u0086@¢\u0006\u0004\b/\u00100\u001az\u0010.\u001a\u00020\u0003*\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00132\u0014\b\u0002\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030\u00012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\"\u0010\u000e\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030 \u0012\u0006\u0012\u0004\u0018\u00010!0\u001fH\u0086@¢\u0006\u0004\b1\u00102\u001ah\u0010\u0012\u001a\u000205*\u00020\u00072\u001a\u00104\u001a\u0016\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010!0\u001f2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030\u0001H\u0086@¢\u0006\u0004\b\u001c\u00106\u001a\u009a\u0001\u0010\u0012\u001a\u000205*\u00020\u00072\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00132\u001a\u00104\u001a\u0016\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010!0\u001f2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030\u0001H\u0086@¢\u0006\u0004\b7\u00108\u001ar\u0010\u0012\u001a\u000205*\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00132\u001a\u00104\u001a\u0016\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010!0\u001f2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030\u0001H\u0086@¢\u0006\u0004\b9\u0010:\u001a\u008c\u0001\u0010$\u001a\u00020\u0003*\u00020\u00072\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030\u00012\u001a\u00104\u001a\u0016\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010!0\u001f2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\"\u0010\u000e\u001a\u001e\b\u0001\u0012\u0004\u0012\u000205\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030 \u0012\u0006\u0012\u0004\u0018\u00010!0\u001fH\u0086@¢\u0006\u0004\b;\u0010<\u001a¾\u0001\u0010$\u001a\u00020\u0003*\u00020\u00072\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00132\u001a\u00104\u001a\u0016\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010!0\u001f2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\u0014\b\u0002\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030\u00012\"\u0010\u000e\u001a\u001e\b\u0001\u0012\u0004\u0012\u000205\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030 \u0012\u0006\u0012\u0004\u0018\u00010!0\u001fH\u0086@¢\u0006\u0004\b=\u0010>\u001a\u0096\u0001\u0010$\u001a\u00020\u0003*\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00132\u001a\u00104\u001a\u0016\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010!0\u001f2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\u0014\b\u0002\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030\u00012\"\u0010\u000e\u001a\u001e\b\u0001\u0012\u0004\u0012\u000205\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030 \u0012\u0006\u0012\u0004\u0018\u00010!0\u001fH\u0086@¢\u0006\u0004\b?\u0010@\u001ah\u0010*\u001a\u000205*\u00020\u00072\u001a\u00104\u001a\u0016\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010!0\u001f2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030\u0001H\u0086@¢\u0006\u0004\b,\u00106\u001a\u009a\u0001\u0010*\u001a\u000205*\u00020\u00072\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00132\u001a\u00104\u001a\u0016\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010!0\u001f2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030\u0001H\u0086@¢\u0006\u0004\bA\u00108\u001ar\u0010*\u001a\u000205*\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00132\u001a\u00104\u001a\u0016\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010!0\u001f2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030\u0001H\u0086@¢\u0006\u0004\bB\u0010:\u001a\u008c\u0001\u0010.\u001a\u00020\u0003*\u00020\u00072\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030\u00012\u001a\u00104\u001a\u0016\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010!0\u001f2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\"\u0010\u000e\u001a\u001e\b\u0001\u0012\u0004\u0012\u000205\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030 \u0012\u0006\u0012\u0004\u0018\u00010!0\u001fH\u0086@¢\u0006\u0004\b1\u0010<\u001a¾\u0001\u0010.\u001a\u00020\u0003*\u00020\u00072\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00132\u0014\b\u0002\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030\u00012\u001a\u00104\u001a\u0016\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010!0\u001f2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\"\u0010\u000e\u001a\u001e\b\u0001\u0012\u0004\u0012\u000205\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030 \u0012\u0006\u0012\u0004\u0018\u00010!0\u001fH\u0086@¢\u0006\u0004\bC\u0010D\u001a\u0096\u0001\u0010.\u001a\u00020\u0003*\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00132\u0014\b\u0002\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030\u00012\u001a\u00104\u001a\u0016\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010!0\u001f2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\"\u0010\u000e\u001a\u001e\b\u0001\u0012\u0004\u0012\u000205\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030 \u0012\u0006\u0012\u0004\u0018\u00010!0\u001fH\u0086@¢\u0006\u0004\bE\u0010F\u001ab\u0010K\u001a\u00028\u0000\"\u0006\b\u0000\u0010G\u0018\u0001*\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\n2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030\u00012\u0012\u0010H\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030\u0001H\u0082H¢\u0006\u0004\bI\u0010J\u001a5\u0010O\u001a\u00020\u0003\"\b\b\u0000\u0010G*\u00020!*\u00020\r2\f\u0010M\u001a\b\u0012\u0004\u0012\u00028\u00000L2\b\u0010N\u001a\u0004\u0018\u00018\u0000H\u0002¢\u0006\u0004\bO\u0010P\u001a/\u0010W\u001a\u00020U*\u00020\u00072\b\u0010R\u001a\u0004\u0018\u00010Q2\b\u0010T\u001a\u0004\u0018\u00010S2\u0006\u0010V\u001a\u00020UH\u0002¢\u0006\u0004\bW\u0010X\u001a\u0019\u0010[\u001a\u00020\u0003*\u00020\r2\u0006\u0010Z\u001a\u00020Y¢\u0006\u0004\b[\u0010\\\" \u0010]\u001a\b\u0012\u0004\u0012\u00020\n0L8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`\" \u0010a\u001a\b\u0012\u0004\u0012\u00020\b0L8\u0000X\u0080\u0004¢\u0006\f\n\u0004\ba\u0010^\u001a\u0004\bb\u0010`\" \u0010c\u001a\b\u0012\u0004\u0012\u00020\n0L8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bc\u0010^\u001a\u0004\bd\u0010`\" \u0010e\u001a\b\u0012\u0004\u0012\u00020\n0L8\u0000X\u0080\u0004¢\u0006\f\n\u0004\be\u0010^\u001a\u0004\bf\u0010`\"4\u0010g\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010!0\u001f0L8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bg\u0010^\u001a\u0004\bh\u0010`\" \u0010i\u001a\b\u0012\u0004\u0012\u00020Y0L8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bi\u0010^\u001a\u0004\bj\u0010`¨\u0006k"}, d2 = {"Lio/ktor/client/HttpClientConfig;", "Lkotlin/Function1;", "Lio/ktor/client/plugins/sse/SSEConfig;", "LY8/t;", "config", "SSE", "(Lio/ktor/client/HttpClientConfig;Lp9/l;)V", "Lio/ktor/client/HttpClient;", "Lkotlin/time/a;", "reconnectionTime", "", "showCommentEvents", "showRetryEvents", "Lio/ktor/client/request/HttpRequestBuilder;", "block", "Lio/ktor/client/plugins/sse/ClientSSESession;", "serverSentEventsSession-i8z2VEo", "(Lio/ktor/client/HttpClient;Lkotlin/time/a;Ljava/lang/Boolean;Ljava/lang/Boolean;Lp9/l;Le9/c;)Ljava/lang/Object;", "serverSentEventsSession", "", "scheme", "host", "", "port", "path", "serverSentEventsSession-xEWcMm4", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lkotlin/time/a;Ljava/lang/Boolean;Ljava/lang/Boolean;Lp9/l;Le9/c;)Ljava/lang/Object;", "urlString", "serverSentEventsSession-mY9Nd3A", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Lkotlin/time/a;Ljava/lang/Boolean;Ljava/lang/Boolean;Lp9/l;Le9/c;)Ljava/lang/Object;", "request", "Lkotlin/Function2;", "Le9/c;", "", "serverSentEvents-mY9Nd3A", "(Lio/ktor/client/HttpClient;Lp9/l;Lkotlin/time/a;Ljava/lang/Boolean;Ljava/lang/Boolean;Lp9/p;Le9/c;)Ljava/lang/Object;", "serverSentEvents", "serverSentEvents-1wIb-0I", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lkotlin/time/a;Ljava/lang/Boolean;Ljava/lang/Boolean;Lp9/l;Lp9/p;Le9/c;)Ljava/lang/Object;", "serverSentEvents-3bFjkrY", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Lkotlin/time/a;Ljava/lang/Boolean;Ljava/lang/Boolean;Lp9/l;Lp9/p;Le9/c;)Ljava/lang/Object;", "sseSession-i8z2VEo", "sseSession", "sseSession-xEWcMm4", "sseSession-mY9Nd3A", "sse-mY9Nd3A", "sse", "sse-tL6_L-A", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lp9/l;Lkotlin/time/a;Ljava/lang/Boolean;Ljava/lang/Boolean;Lp9/p;Le9/c;)Ljava/lang/Object;", "sse-Mswn-_c", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Lp9/l;Lkotlin/time/a;Ljava/lang/Boolean;Ljava/lang/Boolean;Lp9/p;Le9/c;)Ljava/lang/Object;", "Lio/ktor/util/reflect/TypeInfo;", "deserialize", "Lio/ktor/client/plugins/sse/ClientSSESessionWithDeserialization;", "(Lio/ktor/client/HttpClient;Lp9/p;Lkotlin/time/a;Ljava/lang/Boolean;Ljava/lang/Boolean;Lp9/l;Le9/c;)Ljava/lang/Object;", "serverSentEventsSession-tL6_L-A", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lp9/p;Lkotlin/time/a;Ljava/lang/Boolean;Ljava/lang/Boolean;Lp9/l;Le9/c;)Ljava/lang/Object;", "serverSentEventsSession-Mswn-_c", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Lp9/p;Lkotlin/time/a;Ljava/lang/Boolean;Ljava/lang/Boolean;Lp9/l;Le9/c;)Ljava/lang/Object;", "serverSentEvents-Mswn-_c", "(Lio/ktor/client/HttpClient;Lp9/l;Lp9/p;Lkotlin/time/a;Ljava/lang/Boolean;Ljava/lang/Boolean;Lp9/p;Le9/c;)Ljava/lang/Object;", "serverSentEvents-BqdlHlk", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lp9/p;Lkotlin/time/a;Ljava/lang/Boolean;Ljava/lang/Boolean;Lp9/l;Lp9/p;Le9/c;)Ljava/lang/Object;", "serverSentEvents-pTj2aPc", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Lp9/p;Lkotlin/time/a;Ljava/lang/Boolean;Ljava/lang/Boolean;Lp9/l;Lp9/p;Le9/c;)Ljava/lang/Object;", "sseSession-tL6_L-A", "sseSession-Mswn-_c", "sse-BAHpl2s", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lp9/l;Lp9/p;Lkotlin/time/a;Ljava/lang/Boolean;Ljava/lang/Boolean;Lp9/p;Le9/c;)Ljava/lang/Object;", "sse-Q9yt8Vw", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Lp9/l;Lp9/p;Lkotlin/time/a;Ljava/lang/Boolean;Ljava/lang/Boolean;Lp9/p;Le9/c;)Ljava/lang/Object;", ExifInterface.GPS_DIRECTION_TRUE, "additionalAttributes", "processSession-rp2poPw", "(Lio/ktor/client/HttpClient;Lkotlin/time/a;Ljava/lang/Boolean;Ljava/lang/Boolean;Lp9/l;Lp9/l;Le9/c;)Ljava/lang/Object;", "processSession", "Lio/ktor/util/AttributeKey;", "attributeKey", UxipConstants.f30680s, "addAttribute", "(Lio/ktor/client/request/HttpRequestBuilder;Lio/ktor/util/AttributeKey;Ljava/lang/Object;)V", "Lio/ktor/client/call/HttpClientCall;", "call", "", "body", "", "cause", "mapToSSEException", "(Lio/ktor/client/HttpClient;Lio/ktor/client/call/HttpClientCall;[BLjava/lang/Throwable;)Ljava/lang/Throwable;", "Lio/ktor/client/plugins/sse/SSEBufferPolicy;", PolicySdkConstants.policyFileDir, "bufferPolicy", "(Lio/ktor/client/request/HttpRequestBuilder;Lio/ktor/client/plugins/sse/SSEBufferPolicy;)V", "sseRequestAttr", "Lio/ktor/util/AttributeKey;", "getSseRequestAttr", "()Lio/ktor/util/AttributeKey;", "reconnectionTimeAttr", "getReconnectionTimeAttr", "showCommentEventsAttr", "getShowCommentEventsAttr", "showRetryEventsAttr", "getShowRetryEventsAttr", "deserializerAttr", "getDeserializerAttr", "sseBufferPolicyAttr", "getSseBufferPolicyAttr", "ktor-client-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class BuildersKt {
    private static final AttributeKey<p9.p<TypeInfo, String, Object>> deserializerAttr;
    private static final AttributeKey<kotlin.time.a> reconnectionTimeAttr;
    private static final AttributeKey<Boolean> showCommentEventsAttr;
    private static final AttributeKey<Boolean> showRetryEventsAttr;
    private static final AttributeKey<SSEBufferPolicy> sseBufferPolicyAttr;
    private static final AttributeKey<Boolean> sseRequestAttr;

    static {
        InterfaceC5755n interfaceC5755nM;
        InterfaceC5755n interfaceC5755nM2;
        InterfaceC5755n interfaceC5755nM3;
        InterfaceC5755n interfaceC5755nM4;
        InterfaceC5755n interfaceC5755nP;
        Class cls = Boolean.TYPE;
        InterfaceC5745d interfaceC5745dB = kotlin.jvm.internal.t.b(Boolean.class);
        InterfaceC5755n interfaceC5755nM5 = null;
        try {
            interfaceC5755nM = kotlin.jvm.internal.t.m(cls);
        } catch (Throwable unused) {
            interfaceC5755nM = null;
        }
        sseRequestAttr = new AttributeKey<>("SSERequestFlag", new TypeInfo(interfaceC5745dB, interfaceC5755nM));
        InterfaceC5745d interfaceC5745dB2 = kotlin.jvm.internal.t.b(kotlin.time.a.class);
        try {
            interfaceC5755nM2 = kotlin.jvm.internal.t.m(kotlin.time.a.class);
        } catch (Throwable unused2) {
            interfaceC5755nM2 = null;
        }
        reconnectionTimeAttr = new AttributeKey<>("SSEReconnectionTime", new TypeInfo(interfaceC5745dB2, interfaceC5755nM2));
        InterfaceC5745d interfaceC5745dB3 = kotlin.jvm.internal.t.b(Boolean.class);
        try {
            interfaceC5755nM3 = kotlin.jvm.internal.t.m(cls);
        } catch (Throwable unused3) {
            interfaceC5755nM3 = null;
        }
        showCommentEventsAttr = new AttributeKey<>("SSEShowCommentEvents", new TypeInfo(interfaceC5745dB3, interfaceC5755nM3));
        InterfaceC5745d interfaceC5745dB4 = kotlin.jvm.internal.t.b(Boolean.class);
        try {
            interfaceC5755nM4 = kotlin.jvm.internal.t.m(cls);
        } catch (Throwable unused4) {
            interfaceC5755nM4 = null;
        }
        showRetryEventsAttr = new AttributeKey<>("SSEShowRetryEvents", new TypeInfo(interfaceC5745dB4, interfaceC5755nM4));
        InterfaceC5745d interfaceC5745dB5 = kotlin.jvm.internal.t.b(p9.p.class);
        try {
            C5757p.Companion companion = C5757p.INSTANCE;
            interfaceC5755nP = kotlin.jvm.internal.t.p(p9.p.class, companion.d(kotlin.jvm.internal.t.m(TypeInfo.class)), companion.d(kotlin.jvm.internal.t.m(String.class)), companion.d(kotlin.jvm.internal.t.g(Object.class)));
        } catch (Throwable unused5) {
            interfaceC5755nP = null;
        }
        deserializerAttr = new AttributeKey<>("SSEDeserializer", new TypeInfo(interfaceC5745dB5, interfaceC5755nP));
        InterfaceC5745d interfaceC5745dB6 = kotlin.jvm.internal.t.b(SSEBufferPolicy.class);
        try {
            interfaceC5755nM5 = kotlin.jvm.internal.t.m(SSEBufferPolicy.class);
        } catch (Throwable unused6) {
        }
        sseBufferPolicyAttr = new AttributeKey<>("bufferPolicy", new TypeInfo(interfaceC5745dB6, interfaceC5755nM5));
    }

    public static final void SSE(HttpClientConfig<?> httpClientConfig, final InterfaceC5074l<? super SSEConfig, Y8.t> config) {
        kotlin.jvm.internal.p.i(httpClientConfig, "<this>");
        kotlin.jvm.internal.p.i(config, "config");
        httpClientConfig.install(SSEKt.getSSE(), new InterfaceC5074l() { // from class: io.ktor.client.plugins.sse.f
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return BuildersKt.SSE$lambda$0(config, (SSEConfig) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t SSE$lambda$0(InterfaceC5074l interfaceC5074l, SSEConfig install) {
        kotlin.jvm.internal.p.i(install, "$this$install");
        interfaceC5074l.invoke(install);
        return Y8.t.f7040a;
    }

    private static final <T> void addAttribute(HttpRequestBuilder httpRequestBuilder, AttributeKey<T> attributeKey, T t10) {
        if (t10 != null) {
            httpRequestBuilder.getAttributes().put(attributeKey, t10);
        }
    }

    public static final void bufferPolicy(HttpRequestBuilder httpRequestBuilder, SSEBufferPolicy policy) {
        kotlin.jvm.internal.p.i(httpRequestBuilder, "<this>");
        kotlin.jvm.internal.p.i(policy, "policy");
        httpRequestBuilder.getAttributes().put(sseBufferPolicyAttr, policy);
    }

    public static final AttributeKey<p9.p<TypeInfo, String, Object>> getDeserializerAttr() {
        return deserializerAttr;
    }

    public static final AttributeKey<kotlin.time.a> getReconnectionTimeAttr() {
        return reconnectionTimeAttr;
    }

    public static final AttributeKey<Boolean> getShowCommentEventsAttr() {
        return showCommentEventsAttr;
    }

    public static final AttributeKey<Boolean> getShowRetryEventsAttr() {
        return showRetryEventsAttr;
    }

    public static final AttributeKey<SSEBufferPolicy> getSseBufferPolicyAttr() {
        return sseBufferPolicyAttr;
    }

    public static final AttributeKey<Boolean> getSseRequestAttr() {
        return sseRequestAttr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Throwable mapToSSEException(HttpClient httpClient, HttpClientCall httpClientCall, byte[] bArr, Throwable th) {
        SavedHttpResponse savedHttpResponse;
        if (httpClientCall == null) {
            savedHttpResponse = null;
        } else {
            if (bArr == null) {
                bArr = new byte[0];
            }
            SavedHttpCall savedHttpCall = new SavedHttpCall(httpClient, httpClientCall.getRequest(), httpClientCall.getResponse(), bArr);
            savedHttpCall.getAttributes().remove(HttpClientCall.INSTANCE.getCustomResponse$ktor_client_core());
            savedHttpCall.getAttributes().remove(sseRequestAttr);
            savedHttpResponse = new SavedHttpResponse(savedHttpCall, bArr, httpClientCall.getResponse());
            savedHttpCall.setResponse$ktor_client_core(savedHttpResponse);
        }
        return (!(th instanceof SSEClientException) || ((SSEClientException) th).getResponse() == null) ? new SSEClientException(savedHttpResponse, th, th.getMessage()) : th;
    }

    /* renamed from: processSession-rp2poPw, reason: not valid java name */
    private static final /* synthetic */ <T> Object m85processSessionrp2poPw(HttpClient httpClient, kotlin.time.a aVar, Boolean bool, Boolean bool2, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l2, InterfaceC4014c<? super T> interfaceC4014c) {
        HttpClientPluginKt.plugin(httpClient, SSEKt.getSSE());
        InterfaceC1083u interfaceC1083uC = C1087w.c(null, 1, null);
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        interfaceC5074l.invoke(httpRequestBuilder);
        addAttribute(httpRequestBuilder, sseRequestAttr, Boolean.TRUE);
        addAttribute(httpRequestBuilder, reconnectionTimeAttr, aVar);
        addAttribute(httpRequestBuilder, showCommentEventsAttr, bool);
        addAttribute(httpRequestBuilder, showRetryEventsAttr, bool2);
        interfaceC5074l2.invoke(httpRequestBuilder);
        Y8.t tVar = Y8.t.f7040a;
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        kotlin.jvm.internal.p.n();
        C1060i.d(httpClient, null, null, new BuildersKt$processSession$2(httpStatement, interfaceC1083uC, httpClient, null), 3, null);
        kotlin.jvm.internal.n.c(0);
        Object objA1 = interfaceC1083uC.a1(interfaceC4014c);
        kotlin.jvm.internal.n.c(1);
        return objA1;
    }

    /* renamed from: serverSentEvents-1wIb-0I, reason: not valid java name */
    public static final Object m86serverSentEvents1wIb0I(HttpClient httpClient, final String str, final String str2, final Integer num, final String str3, kotlin.time.a aVar, Boolean bool, Boolean bool2, final InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, p9.p<? super ClientSSESession, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> pVar, InterfaceC4014c<? super Y8.t> interfaceC4014c) throws Throwable {
        Object objM94serverSentEventsmY9Nd3A = m94serverSentEventsmY9Nd3A(httpClient, new InterfaceC5074l() { // from class: io.ktor.client.plugins.sse.a
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return BuildersKt.serverSentEvents_1wIb_0I$lambda$7(str, str2, num, str3, interfaceC5074l, (HttpRequestBuilder) obj);
            }
        }, aVar, bool, bool2, pVar, interfaceC4014c);
        return objM94serverSentEventsmY9Nd3A == C4063a.g() ? objM94serverSentEventsmY9Nd3A : Y8.t.f7040a;
    }

    /* renamed from: serverSentEvents-1wIb-0I$default, reason: not valid java name */
    public static /* synthetic */ Object m87serverSentEvents1wIb0I$default(HttpClient httpClient, String str, String str2, Integer num, String str3, kotlin.time.a aVar, Boolean bool, Boolean bool2, InterfaceC5074l interfaceC5074l, p9.p pVar, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        if ((i10 & 4) != 0) {
            num = null;
        }
        if ((i10 & 8) != 0) {
            str3 = null;
        }
        if ((i10 & 16) != 0) {
            aVar = null;
        }
        if ((i10 & 32) != 0) {
            bool = null;
        }
        if ((i10 & 64) != 0) {
            bool2 = null;
        }
        if ((i10 & 128) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.client.plugins.sse.j
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return BuildersKt.serverSentEvents_1wIb_0I$lambda$6((HttpRequestBuilder) obj2);
                }
            };
        }
        return m86serverSentEvents1wIb0I(httpClient, str, str2, num, str3, aVar, bool, bool2, interfaceC5074l, pVar, interfaceC4014c);
    }

    /* renamed from: serverSentEvents-3bFjkrY, reason: not valid java name */
    public static final Object m88serverSentEvents3bFjkrY(HttpClient httpClient, final String str, kotlin.time.a aVar, Boolean bool, Boolean bool2, final InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, p9.p<? super ClientSSESession, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> pVar, InterfaceC4014c<? super Y8.t> interfaceC4014c) throws Throwable {
        Object objM94serverSentEventsmY9Nd3A = m94serverSentEventsmY9Nd3A(httpClient, new InterfaceC5074l() { // from class: io.ktor.client.plugins.sse.e
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return BuildersKt.serverSentEvents_3bFjkrY$lambda$9(str, interfaceC5074l, (HttpRequestBuilder) obj);
            }
        }, aVar, bool, bool2, pVar, interfaceC4014c);
        return objM94serverSentEventsmY9Nd3A == C4063a.g() ? objM94serverSentEventsmY9Nd3A : Y8.t.f7040a;
    }

    /* renamed from: serverSentEvents-3bFjkrY$default, reason: not valid java name */
    public static /* synthetic */ Object m89serverSentEvents3bFjkrY$default(HttpClient httpClient, String str, kotlin.time.a aVar, Boolean bool, Boolean bool2, InterfaceC5074l interfaceC5074l, p9.p pVar, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            aVar = null;
        }
        if ((i10 & 4) != 0) {
            bool = null;
        }
        if ((i10 & 8) != 0) {
            bool2 = null;
        }
        if ((i10 & 16) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.client.plugins.sse.i
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return BuildersKt.serverSentEvents_3bFjkrY$lambda$8((HttpRequestBuilder) obj2);
                }
            };
        }
        return m88serverSentEvents3bFjkrY(httpClient, str, aVar, bool, bool2, interfaceC5074l, pVar, interfaceC4014c);
    }

    /* renamed from: serverSentEvents-BqdlHlk, reason: not valid java name */
    public static final Object m90serverSentEventsBqdlHlk(HttpClient httpClient, final String str, final String str2, final Integer num, final String str3, p9.p<? super TypeInfo, ? super String, ? extends Object> pVar, kotlin.time.a aVar, Boolean bool, Boolean bool2, final InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, p9.p<? super ClientSSESessionWithDeserialization, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> pVar2, InterfaceC4014c<? super Y8.t> interfaceC4014c) throws Throwable {
        Object objM92serverSentEventsMswn_c = m92serverSentEventsMswn_c(httpClient, new InterfaceC5074l() { // from class: io.ktor.client.plugins.sse.r
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return BuildersKt.serverSentEvents_BqdlHlk$lambda$20(str, str2, num, str3, interfaceC5074l, (HttpRequestBuilder) obj);
            }
        }, pVar, aVar, bool, bool2, pVar2, interfaceC4014c);
        return objM92serverSentEventsMswn_c == C4063a.g() ? objM92serverSentEventsMswn_c : Y8.t.f7040a;
    }

    /* renamed from: serverSentEvents-BqdlHlk$default, reason: not valid java name */
    public static /* synthetic */ Object m91serverSentEventsBqdlHlk$default(HttpClient httpClient, String str, String str2, Integer num, String str3, p9.p pVar, kotlin.time.a aVar, Boolean bool, Boolean bool2, InterfaceC5074l interfaceC5074l, p9.p pVar2, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        if ((i10 & 4) != 0) {
            num = null;
        }
        if ((i10 & 8) != 0) {
            str3 = null;
        }
        if ((i10 & 32) != 0) {
            aVar = null;
        }
        if ((i10 & 64) != 0) {
            bool = null;
        }
        if ((i10 & 128) != 0) {
            bool2 = null;
        }
        if ((i10 & 256) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.client.plugins.sse.g
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return BuildersKt.serverSentEvents_BqdlHlk$lambda$19((HttpRequestBuilder) obj2);
                }
            };
        }
        return m90serverSentEventsBqdlHlk(httpClient, str, str2, num, str3, pVar, aVar, bool, bool2, interfaceC5074l, pVar2, interfaceC4014c);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0016  */
    /* renamed from: serverSentEvents-Mswn-_c, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object m92serverSentEventsMswn_c(io.ktor.client.HttpClient r13, p9.InterfaceC5074l<? super io.ktor.client.request.HttpRequestBuilder, Y8.t> r14, p9.p<? super io.ktor.util.reflect.TypeInfo, ? super java.lang.String, ? extends java.lang.Object> r15, kotlin.time.a r16, java.lang.Boolean r17, java.lang.Boolean r18, p9.p<? super io.ktor.client.plugins.sse.ClientSSESessionWithDeserialization, ? super e9.InterfaceC4014c<? super Y8.t>, ? extends java.lang.Object> r19, e9.InterfaceC4014c<? super Y8.t> r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 287
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.sse.BuildersKt.m92serverSentEventsMswn_c(io.ktor.client.HttpClient, p9.l, p9.p, kotlin.time.a, java.lang.Boolean, java.lang.Boolean, p9.p, e9.c):java.lang.Object");
    }

    /* renamed from: serverSentEvents-Mswn-_c$default, reason: not valid java name */
    public static /* synthetic */ Object m93serverSentEventsMswn_c$default(HttpClient httpClient, InterfaceC5074l interfaceC5074l, p9.p pVar, kotlin.time.a aVar, Boolean bool, Boolean bool2, p9.p pVar2, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            aVar = null;
        }
        if ((i10 & 8) != 0) {
            bool = null;
        }
        if ((i10 & 16) != 0) {
            bool2 = null;
        }
        return m92serverSentEventsMswn_c(httpClient, interfaceC5074l, pVar, aVar, bool, bool2, pVar2, interfaceC4014c);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0016  */
    /* renamed from: serverSentEvents-mY9Nd3A, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object m94serverSentEventsmY9Nd3A(io.ktor.client.HttpClient r12, p9.InterfaceC5074l<? super io.ktor.client.request.HttpRequestBuilder, Y8.t> r13, kotlin.time.a r14, java.lang.Boolean r15, java.lang.Boolean r16, p9.p<? super io.ktor.client.plugins.sse.ClientSSESession, ? super e9.InterfaceC4014c<? super Y8.t>, ? extends java.lang.Object> r17, e9.InterfaceC4014c<? super Y8.t> r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 264
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.sse.BuildersKt.m94serverSentEventsmY9Nd3A(io.ktor.client.HttpClient, p9.l, kotlin.time.a, java.lang.Boolean, java.lang.Boolean, p9.p, e9.c):java.lang.Object");
    }

    /* renamed from: serverSentEvents-mY9Nd3A$default, reason: not valid java name */
    public static /* synthetic */ Object m95serverSentEventsmY9Nd3A$default(HttpClient httpClient, InterfaceC5074l interfaceC5074l, kotlin.time.a aVar, Boolean bool, Boolean bool2, p9.p pVar, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            aVar = null;
        }
        if ((i10 & 4) != 0) {
            bool = null;
        }
        if ((i10 & 8) != 0) {
            bool2 = null;
        }
        return m94serverSentEventsmY9Nd3A(httpClient, interfaceC5074l, aVar, bool, bool2, pVar, interfaceC4014c);
    }

    /* renamed from: serverSentEvents-pTj2aPc, reason: not valid java name */
    public static final Object m96serverSentEventspTj2aPc(HttpClient httpClient, final String str, p9.p<? super TypeInfo, ? super String, ? extends Object> pVar, kotlin.time.a aVar, Boolean bool, Boolean bool2, final InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, p9.p<? super ClientSSESessionWithDeserialization, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> pVar2, InterfaceC4014c<? super Y8.t> interfaceC4014c) throws Throwable {
        Object objM92serverSentEventsMswn_c = m92serverSentEventsMswn_c(httpClient, new InterfaceC5074l() { // from class: io.ktor.client.plugins.sse.l
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return BuildersKt.serverSentEvents_pTj2aPc$lambda$22(str, interfaceC5074l, (HttpRequestBuilder) obj);
            }
        }, pVar, aVar, bool, bool2, pVar2, interfaceC4014c);
        return objM92serverSentEventsMswn_c == C4063a.g() ? objM92serverSentEventsMswn_c : Y8.t.f7040a;
    }

    /* renamed from: serverSentEvents-pTj2aPc$default, reason: not valid java name */
    public static /* synthetic */ Object m97serverSentEventspTj2aPc$default(HttpClient httpClient, String str, p9.p pVar, kotlin.time.a aVar, Boolean bool, Boolean bool2, InterfaceC5074l interfaceC5074l, p9.p pVar2, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            aVar = null;
        }
        if ((i10 & 8) != 0) {
            bool = null;
        }
        if ((i10 & 16) != 0) {
            bool2 = null;
        }
        if ((i10 & 32) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.client.plugins.sse.m
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return BuildersKt.serverSentEvents_pTj2aPc$lambda$21((HttpRequestBuilder) obj2);
                }
            };
        }
        return m96serverSentEventspTj2aPc(httpClient, str, pVar, aVar, bool, bool2, interfaceC5074l, pVar2, interfaceC4014c);
    }

    /* renamed from: serverSentEventsSession-Mswn-_c, reason: not valid java name */
    public static final Object m98serverSentEventsSessionMswn_c(HttpClient httpClient, final String str, p9.p<? super TypeInfo, ? super String, ? extends Object> pVar, kotlin.time.a aVar, Boolean bool, Boolean bool2, final InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super ClientSSESessionWithDeserialization> interfaceC4014c) {
        return m103serverSentEventsSessionmY9Nd3A(httpClient, pVar, aVar, bool, bool2, (InterfaceC5074l<? super HttpRequestBuilder, Y8.t>) new InterfaceC5074l() { // from class: io.ktor.client.plugins.sse.c
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return BuildersKt.serverSentEventsSession_Mswn__c$lambda$18(str, interfaceC5074l, (HttpRequestBuilder) obj);
            }
        }, interfaceC4014c);
    }

    /* renamed from: serverSentEventsSession-Mswn-_c$default, reason: not valid java name */
    public static /* synthetic */ Object m99serverSentEventsSessionMswn_c$default(HttpClient httpClient, String str, p9.p pVar, kotlin.time.a aVar, Boolean bool, Boolean bool2, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            aVar = null;
        }
        if ((i10 & 8) != 0) {
            bool = null;
        }
        if ((i10 & 16) != 0) {
            bool2 = null;
        }
        if ((i10 & 32) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.client.plugins.sse.h
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return BuildersKt.serverSentEventsSession_Mswn__c$lambda$17((HttpRequestBuilder) obj2);
                }
            };
        }
        return m98serverSentEventsSessionMswn_c(httpClient, str, pVar, aVar, bool, bool2, interfaceC5074l, interfaceC4014c);
    }

    /* renamed from: serverSentEventsSession-i8z2VEo, reason: not valid java name */
    public static final Object m100serverSentEventsSessioni8z2VEo(HttpClient httpClient, kotlin.time.a aVar, Boolean bool, Boolean bool2, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super ClientSSESession> interfaceC4014c) {
        HttpClientPluginKt.plugin(httpClient, SSEKt.getSSE());
        InterfaceC1083u interfaceC1083uC = C1087w.c(null, 1, null);
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        interfaceC5074l.invoke(httpRequestBuilder);
        addAttribute(httpRequestBuilder, sseRequestAttr, C4109a.a(true));
        addAttribute(httpRequestBuilder, reconnectionTimeAttr, aVar);
        addAttribute(httpRequestBuilder, showCommentEventsAttr, bool);
        addAttribute(httpRequestBuilder, showRetryEventsAttr, bool2);
        C1060i.d(httpClient, null, null, new BuildersKt$serverSentEventsSessioni8z2VEo$$inlined$processSessionrp2poPw$1(new HttpStatement(httpRequestBuilder, httpClient), interfaceC1083uC, httpClient, null), 3, null);
        return interfaceC1083uC.a1(interfaceC4014c);
    }

    /* renamed from: serverSentEventsSession-i8z2VEo$default, reason: not valid java name */
    public static /* synthetic */ Object m101serverSentEventsSessioni8z2VEo$default(HttpClient httpClient, kotlin.time.a aVar, Boolean bool, Boolean bool2, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            aVar = null;
        }
        if ((i10 & 2) != 0) {
            bool = null;
        }
        if ((i10 & 4) != 0) {
            bool2 = null;
        }
        return m100serverSentEventsSessioni8z2VEo(httpClient, aVar, bool, bool2, interfaceC5074l, interfaceC4014c);
    }

    /* renamed from: serverSentEventsSession-mY9Nd3A, reason: not valid java name */
    public static final Object m102serverSentEventsSessionmY9Nd3A(HttpClient httpClient, final String str, kotlin.time.a aVar, Boolean bool, Boolean bool2, final InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super ClientSSESession> interfaceC4014c) {
        return m100serverSentEventsSessioni8z2VEo(httpClient, aVar, bool, bool2, new InterfaceC5074l() { // from class: io.ktor.client.plugins.sse.q
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return BuildersKt.serverSentEventsSession_mY9Nd3A$lambda$5(str, interfaceC5074l, (HttpRequestBuilder) obj);
            }
        }, interfaceC4014c);
    }

    /* renamed from: serverSentEventsSession-mY9Nd3A$default, reason: not valid java name */
    public static /* synthetic */ Object m104serverSentEventsSessionmY9Nd3A$default(HttpClient httpClient, String str, kotlin.time.a aVar, Boolean bool, Boolean bool2, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            aVar = null;
        }
        if ((i10 & 4) != 0) {
            bool = null;
        }
        if ((i10 & 8) != 0) {
            bool2 = null;
        }
        if ((i10 & 16) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.client.plugins.sse.y
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return BuildersKt.serverSentEventsSession_mY9Nd3A$lambda$4((HttpRequestBuilder) obj2);
                }
            };
        }
        return m102serverSentEventsSessionmY9Nd3A(httpClient, str, aVar, bool, bool2, (InterfaceC5074l<? super HttpRequestBuilder, Y8.t>) interfaceC5074l, (InterfaceC4014c<? super ClientSSESession>) interfaceC4014c);
    }

    /* renamed from: serverSentEventsSession-tL6_L-A, reason: not valid java name */
    public static final Object m106serverSentEventsSessiontL6_LA(HttpClient httpClient, final String str, final String str2, final Integer num, final String str3, p9.p<? super TypeInfo, ? super String, ? extends Object> pVar, kotlin.time.a aVar, Boolean bool, Boolean bool2, final InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super ClientSSESessionWithDeserialization> interfaceC4014c) {
        return m103serverSentEventsSessionmY9Nd3A(httpClient, pVar, aVar, bool, bool2, (InterfaceC5074l<? super HttpRequestBuilder, Y8.t>) new InterfaceC5074l() { // from class: io.ktor.client.plugins.sse.d
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return BuildersKt.serverSentEventsSession_tL6_L_A$lambda$16(str, str2, num, str3, interfaceC5074l, (HttpRequestBuilder) obj);
            }
        }, interfaceC4014c);
    }

    /* renamed from: serverSentEventsSession-tL6_L-A$default, reason: not valid java name */
    public static /* synthetic */ Object m107serverSentEventsSessiontL6_LA$default(HttpClient httpClient, String str, String str2, Integer num, String str3, p9.p pVar, kotlin.time.a aVar, Boolean bool, Boolean bool2, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        if ((i10 & 4) != 0) {
            num = null;
        }
        if ((i10 & 8) != 0) {
            str3 = null;
        }
        if ((i10 & 32) != 0) {
            aVar = null;
        }
        if ((i10 & 64) != 0) {
            bool = null;
        }
        if ((i10 & 128) != 0) {
            bool2 = null;
        }
        if ((i10 & 256) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.client.plugins.sse.o
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return BuildersKt.serverSentEventsSession_tL6_L_A$lambda$15((HttpRequestBuilder) obj2);
                }
            };
        }
        return m106serverSentEventsSessiontL6_LA(httpClient, str, str2, num, str3, pVar, aVar, bool, bool2, interfaceC5074l, interfaceC4014c);
    }

    /* renamed from: serverSentEventsSession-xEWcMm4, reason: not valid java name */
    public static final Object m108serverSentEventsSessionxEWcMm4(HttpClient httpClient, final String str, final String str2, final Integer num, final String str3, kotlin.time.a aVar, Boolean bool, Boolean bool2, final InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super ClientSSESession> interfaceC4014c) {
        return m100serverSentEventsSessioni8z2VEo(httpClient, aVar, bool, bool2, new InterfaceC5074l() { // from class: io.ktor.client.plugins.sse.b
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return BuildersKt.serverSentEventsSession_xEWcMm4$lambda$3(str, str2, num, str3, interfaceC5074l, (HttpRequestBuilder) obj);
            }
        }, interfaceC4014c);
    }

    /* renamed from: serverSentEventsSession-xEWcMm4$default, reason: not valid java name */
    public static /* synthetic */ Object m109serverSentEventsSessionxEWcMm4$default(HttpClient httpClient, String str, String str2, Integer num, String str3, kotlin.time.a aVar, Boolean bool, Boolean bool2, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        if ((i10 & 4) != 0) {
            num = null;
        }
        if ((i10 & 8) != 0) {
            str3 = null;
        }
        if ((i10 & 16) != 0) {
            aVar = null;
        }
        if ((i10 & 32) != 0) {
            bool = null;
        }
        if ((i10 & 64) != 0) {
            bool2 = null;
        }
        if ((i10 & 128) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.client.plugins.sse.t
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return BuildersKt.serverSentEventsSession_xEWcMm4$lambda$2((HttpRequestBuilder) obj2);
                }
            };
        }
        return m108serverSentEventsSessionxEWcMm4(httpClient, str, str2, num, str3, aVar, bool, bool2, interfaceC5074l, interfaceC4014c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t serverSentEventsSession_Mswn__c$lambda$17(HttpRequestBuilder httpRequestBuilder) {
        kotlin.jvm.internal.p.i(httpRequestBuilder, "<this>");
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t serverSentEventsSession_Mswn__c$lambda$18(String str, InterfaceC5074l interfaceC5074l, HttpRequestBuilder serverSentEventsSession) {
        kotlin.jvm.internal.p.i(serverSentEventsSession, "$this$serverSentEventsSession");
        URLParserKt.takeFrom(serverSentEventsSession.getUrl(), str);
        interfaceC5074l.invoke(serverSentEventsSession);
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t serverSentEventsSession_mY9Nd3A$lambda$4(HttpRequestBuilder httpRequestBuilder) {
        kotlin.jvm.internal.p.i(httpRequestBuilder, "<this>");
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t serverSentEventsSession_mY9Nd3A$lambda$5(String str, InterfaceC5074l interfaceC5074l, HttpRequestBuilder serverSentEventsSession) {
        kotlin.jvm.internal.p.i(serverSentEventsSession, "$this$serverSentEventsSession");
        URLParserKt.takeFrom(serverSentEventsSession.getUrl(), str);
        interfaceC5074l.invoke(serverSentEventsSession);
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t serverSentEventsSession_tL6_L_A$lambda$15(HttpRequestBuilder httpRequestBuilder) {
        kotlin.jvm.internal.p.i(httpRequestBuilder, "<this>");
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t serverSentEventsSession_tL6_L_A$lambda$16(String str, String str2, Integer num, String str3, InterfaceC5074l interfaceC5074l, HttpRequestBuilder serverSentEventsSession) {
        kotlin.jvm.internal.p.i(serverSentEventsSession, "$this$serverSentEventsSession");
        HttpRequestKt.url$default(serverSentEventsSession, str, str2, num, str3, null, 16, null);
        interfaceC5074l.invoke(serverSentEventsSession);
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t serverSentEventsSession_xEWcMm4$lambda$2(HttpRequestBuilder httpRequestBuilder) {
        kotlin.jvm.internal.p.i(httpRequestBuilder, "<this>");
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t serverSentEventsSession_xEWcMm4$lambda$3(String str, String str2, Integer num, String str3, InterfaceC5074l interfaceC5074l, HttpRequestBuilder serverSentEventsSession) {
        kotlin.jvm.internal.p.i(serverSentEventsSession, "$this$serverSentEventsSession");
        HttpRequestKt.url$default(serverSentEventsSession, str, str2, num, str3, null, 16, null);
        interfaceC5074l.invoke(serverSentEventsSession);
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t serverSentEvents_1wIb_0I$lambda$6(HttpRequestBuilder httpRequestBuilder) {
        kotlin.jvm.internal.p.i(httpRequestBuilder, "<this>");
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t serverSentEvents_1wIb_0I$lambda$7(String str, String str2, Integer num, String str3, InterfaceC5074l interfaceC5074l, HttpRequestBuilder serverSentEvents) {
        kotlin.jvm.internal.p.i(serverSentEvents, "$this$serverSentEvents");
        HttpRequestKt.url$default(serverSentEvents, str, str2, num, str3, null, 16, null);
        interfaceC5074l.invoke(serverSentEvents);
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t serverSentEvents_3bFjkrY$lambda$8(HttpRequestBuilder httpRequestBuilder) {
        kotlin.jvm.internal.p.i(httpRequestBuilder, "<this>");
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t serverSentEvents_3bFjkrY$lambda$9(String str, InterfaceC5074l interfaceC5074l, HttpRequestBuilder serverSentEvents) {
        kotlin.jvm.internal.p.i(serverSentEvents, "$this$serverSentEvents");
        URLParserKt.takeFrom(serverSentEvents.getUrl(), str);
        interfaceC5074l.invoke(serverSentEvents);
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t serverSentEvents_BqdlHlk$lambda$19(HttpRequestBuilder httpRequestBuilder) {
        kotlin.jvm.internal.p.i(httpRequestBuilder, "<this>");
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t serverSentEvents_BqdlHlk$lambda$20(String str, String str2, Integer num, String str3, InterfaceC5074l interfaceC5074l, HttpRequestBuilder serverSentEvents) {
        kotlin.jvm.internal.p.i(serverSentEvents, "$this$serverSentEvents");
        HttpRequestKt.url$default(serverSentEvents, str, str2, num, str3, null, 16, null);
        interfaceC5074l.invoke(serverSentEvents);
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t serverSentEvents_pTj2aPc$lambda$21(HttpRequestBuilder httpRequestBuilder) {
        kotlin.jvm.internal.p.i(httpRequestBuilder, "<this>");
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t serverSentEvents_pTj2aPc$lambda$22(String str, InterfaceC5074l interfaceC5074l, HttpRequestBuilder serverSentEvents) {
        kotlin.jvm.internal.p.i(serverSentEvents, "$this$serverSentEvents");
        URLParserKt.takeFrom(serverSentEvents.getUrl(), str);
        interfaceC5074l.invoke(serverSentEvents);
        return Y8.t.f7040a;
    }

    /* renamed from: sse-BAHpl2s, reason: not valid java name */
    public static final Object m110sseBAHpl2s(HttpClient httpClient, String str, String str2, Integer num, String str3, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, p9.p<? super TypeInfo, ? super String, ? extends Object> pVar, kotlin.time.a aVar, Boolean bool, Boolean bool2, p9.p<? super ClientSSESessionWithDeserialization, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> pVar2, InterfaceC4014c<? super Y8.t> interfaceC4014c) throws Throwable {
        Object objM90serverSentEventsBqdlHlk = m90serverSentEventsBqdlHlk(httpClient, str, str2, num, str3, pVar, aVar, bool, bool2, interfaceC5074l, pVar2, interfaceC4014c);
        return objM90serverSentEventsBqdlHlk == C4063a.g() ? objM90serverSentEventsBqdlHlk : Y8.t.f7040a;
    }

    /* renamed from: sse-BAHpl2s$default, reason: not valid java name */
    public static /* synthetic */ Object m111sseBAHpl2s$default(HttpClient httpClient, String str, String str2, Integer num, String str3, InterfaceC5074l interfaceC5074l, p9.p pVar, kotlin.time.a aVar, Boolean bool, Boolean bool2, p9.p pVar2, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        if ((i10 & 4) != 0) {
            num = null;
        }
        if ((i10 & 8) != 0) {
            str3 = null;
        }
        if ((i10 & 16) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.client.plugins.sse.s
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return BuildersKt.sse_BAHpl2s$lambda$25((HttpRequestBuilder) obj2);
                }
            };
        }
        if ((i10 & 64) != 0) {
            aVar = null;
        }
        if ((i10 & 128) != 0) {
            bool = null;
        }
        if ((i10 & 256) != 0) {
            bool2 = null;
        }
        return m110sseBAHpl2s(httpClient, str, str2, num, str3, interfaceC5074l, pVar, aVar, bool, bool2, pVar2, interfaceC4014c);
    }

    /* renamed from: sse-Mswn-_c, reason: not valid java name */
    public static final Object m112sseMswn_c(HttpClient httpClient, String str, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, kotlin.time.a aVar, Boolean bool, Boolean bool2, p9.p<? super ClientSSESession, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> pVar, InterfaceC4014c<? super Y8.t> interfaceC4014c) throws Throwable {
        Object objM88serverSentEvents3bFjkrY = m88serverSentEvents3bFjkrY(httpClient, str, aVar, bool, bool2, interfaceC5074l, pVar, interfaceC4014c);
        return objM88serverSentEvents3bFjkrY == C4063a.g() ? objM88serverSentEvents3bFjkrY : Y8.t.f7040a;
    }

    /* renamed from: sse-Mswn-_c$default, reason: not valid java name */
    public static /* synthetic */ Object m114sseMswn_c$default(HttpClient httpClient, String str, InterfaceC5074l interfaceC5074l, kotlin.time.a aVar, Boolean bool, Boolean bool2, p9.p pVar, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        Boolean bool3;
        HttpClient httpClient2;
        String str2;
        p9.p pVar2;
        InterfaceC4014c interfaceC4014c2;
        if ((i10 & 2) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.client.plugins.sse.w
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return BuildersKt.sse_Mswn__c$lambda$13((HttpRequestBuilder) obj2);
                }
            };
        }
        InterfaceC5074l interfaceC5074l2 = interfaceC5074l;
        kotlin.time.a aVar2 = (i10 & 4) != 0 ? null : aVar;
        Boolean bool4 = (i10 & 8) != 0 ? null : bool;
        if ((i10 & 16) != 0) {
            bool3 = null;
            str2 = str;
            pVar2 = pVar;
            interfaceC4014c2 = interfaceC4014c;
            httpClient2 = httpClient;
        } else {
            bool3 = bool2;
            httpClient2 = httpClient;
            str2 = str;
            pVar2 = pVar;
            interfaceC4014c2 = interfaceC4014c;
        }
        return m112sseMswn_c(httpClient2, str2, (InterfaceC5074l<? super HttpRequestBuilder, Y8.t>) interfaceC5074l2, aVar2, bool4, bool3, (p9.p<? super ClientSSESession, ? super InterfaceC4014c<? super Y8.t>, ? extends Object>) pVar2, (InterfaceC4014c<? super Y8.t>) interfaceC4014c2);
    }

    /* renamed from: sse-Q9yt8Vw, reason: not valid java name */
    public static final Object m116sseQ9yt8Vw(HttpClient httpClient, String str, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, p9.p<? super TypeInfo, ? super String, ? extends Object> pVar, kotlin.time.a aVar, Boolean bool, Boolean bool2, p9.p<? super ClientSSESessionWithDeserialization, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> pVar2, InterfaceC4014c<? super Y8.t> interfaceC4014c) throws Throwable {
        Object objM96serverSentEventspTj2aPc = m96serverSentEventspTj2aPc(httpClient, str, pVar, aVar, bool, bool2, interfaceC5074l, pVar2, interfaceC4014c);
        return objM96serverSentEventspTj2aPc == C4063a.g() ? objM96serverSentEventspTj2aPc : Y8.t.f7040a;
    }

    /* renamed from: sse-Q9yt8Vw$default, reason: not valid java name */
    public static /* synthetic */ Object m117sseQ9yt8Vw$default(HttpClient httpClient, String str, InterfaceC5074l interfaceC5074l, p9.p pVar, kotlin.time.a aVar, Boolean bool, Boolean bool2, p9.p pVar2, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        Boolean bool3;
        HttpClient httpClient2;
        String str2;
        p9.p pVar3;
        p9.p pVar4;
        InterfaceC4014c interfaceC4014c2;
        if ((i10 & 2) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.client.plugins.sse.p
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return BuildersKt.sse_Q9yt8Vw$lambda$26((HttpRequestBuilder) obj2);
                }
            };
        }
        InterfaceC5074l interfaceC5074l2 = interfaceC5074l;
        kotlin.time.a aVar2 = (i10 & 8) != 0 ? null : aVar;
        Boolean bool4 = (i10 & 16) != 0 ? null : bool;
        if ((i10 & 32) != 0) {
            bool3 = null;
            str2 = str;
            pVar3 = pVar;
            pVar4 = pVar2;
            interfaceC4014c2 = interfaceC4014c;
            httpClient2 = httpClient;
        } else {
            bool3 = bool2;
            httpClient2 = httpClient;
            str2 = str;
            pVar3 = pVar;
            pVar4 = pVar2;
            interfaceC4014c2 = interfaceC4014c;
        }
        return m116sseQ9yt8Vw(httpClient2, str2, interfaceC5074l2, pVar3, aVar2, bool4, bool3, pVar4, interfaceC4014c2);
    }

    /* renamed from: sse-mY9Nd3A, reason: not valid java name */
    public static final Object m118ssemY9Nd3A(HttpClient httpClient, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, kotlin.time.a aVar, Boolean bool, Boolean bool2, p9.p<? super ClientSSESession, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> pVar, InterfaceC4014c<? super Y8.t> interfaceC4014c) throws Throwable {
        Object objM94serverSentEventsmY9Nd3A = m94serverSentEventsmY9Nd3A(httpClient, interfaceC5074l, aVar, bool, bool2, pVar, interfaceC4014c);
        return objM94serverSentEventsmY9Nd3A == C4063a.g() ? objM94serverSentEventsmY9Nd3A : Y8.t.f7040a;
    }

    /* renamed from: sse-mY9Nd3A$default, reason: not valid java name */
    public static /* synthetic */ Object m119ssemY9Nd3A$default(HttpClient httpClient, InterfaceC5074l interfaceC5074l, kotlin.time.a aVar, Boolean bool, Boolean bool2, p9.p pVar, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            aVar = null;
        }
        if ((i10 & 4) != 0) {
            bool = null;
        }
        if ((i10 & 8) != 0) {
            bool2 = null;
        }
        return m118ssemY9Nd3A(httpClient, interfaceC5074l, aVar, bool, bool2, pVar, interfaceC4014c);
    }

    /* renamed from: sse-tL6_L-A, reason: not valid java name */
    public static final Object m120ssetL6_LA(HttpClient httpClient, String str, String str2, Integer num, String str3, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, kotlin.time.a aVar, Boolean bool, Boolean bool2, p9.p<? super ClientSSESession, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> pVar, InterfaceC4014c<? super Y8.t> interfaceC4014c) throws Throwable {
        Object objM86serverSentEvents1wIb0I = m86serverSentEvents1wIb0I(httpClient, str, str2, num, str3, aVar, bool, bool2, interfaceC5074l, pVar, interfaceC4014c);
        return objM86serverSentEvents1wIb0I == C4063a.g() ? objM86serverSentEvents1wIb0I : Y8.t.f7040a;
    }

    /* renamed from: sse-tL6_L-A$default, reason: not valid java name */
    public static /* synthetic */ Object m121ssetL6_LA$default(HttpClient httpClient, String str, String str2, Integer num, String str3, InterfaceC5074l interfaceC5074l, kotlin.time.a aVar, Boolean bool, Boolean bool2, p9.p pVar, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        if ((i10 & 4) != 0) {
            num = null;
        }
        if ((i10 & 8) != 0) {
            str3 = null;
        }
        if ((i10 & 16) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.client.plugins.sse.k
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return BuildersKt.sse_tL6_L_A$lambda$12((HttpRequestBuilder) obj2);
                }
            };
        }
        if ((i10 & 32) != 0) {
            aVar = null;
        }
        if ((i10 & 64) != 0) {
            bool = null;
        }
        if ((i10 & 128) != 0) {
            bool2 = null;
        }
        return m120ssetL6_LA(httpClient, str, str2, num, str3, interfaceC5074l, aVar, bool, bool2, pVar, interfaceC4014c);
    }

    /* renamed from: sseSession-Mswn-_c, reason: not valid java name */
    public static final Object m122sseSessionMswn_c(HttpClient httpClient, String str, p9.p<? super TypeInfo, ? super String, ? extends Object> pVar, kotlin.time.a aVar, Boolean bool, Boolean bool2, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super ClientSSESessionWithDeserialization> interfaceC4014c) {
        return m98serverSentEventsSessionMswn_c(httpClient, str, pVar, aVar, bool, bool2, interfaceC5074l, interfaceC4014c);
    }

    /* renamed from: sseSession-Mswn-_c$default, reason: not valid java name */
    public static /* synthetic */ Object m123sseSessionMswn_c$default(HttpClient httpClient, String str, p9.p pVar, kotlin.time.a aVar, Boolean bool, Boolean bool2, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            aVar = null;
        }
        if ((i10 & 8) != 0) {
            bool = null;
        }
        if ((i10 & 16) != 0) {
            bool2 = null;
        }
        if ((i10 & 32) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.client.plugins.sse.n
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return BuildersKt.sseSession_Mswn__c$lambda$24((HttpRequestBuilder) obj2);
                }
            };
        }
        return m122sseSessionMswn_c(httpClient, str, pVar, aVar, bool, bool2, interfaceC5074l, interfaceC4014c);
    }

    /* renamed from: sseSession-i8z2VEo, reason: not valid java name */
    public static final Object m124sseSessioni8z2VEo(HttpClient httpClient, kotlin.time.a aVar, Boolean bool, Boolean bool2, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super ClientSSESession> interfaceC4014c) {
        return m100serverSentEventsSessioni8z2VEo(httpClient, aVar, bool, bool2, interfaceC5074l, interfaceC4014c);
    }

    /* renamed from: sseSession-i8z2VEo$default, reason: not valid java name */
    public static /* synthetic */ Object m125sseSessioni8z2VEo$default(HttpClient httpClient, kotlin.time.a aVar, Boolean bool, Boolean bool2, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            aVar = null;
        }
        if ((i10 & 2) != 0) {
            bool = null;
        }
        if ((i10 & 4) != 0) {
            bool2 = null;
        }
        return m124sseSessioni8z2VEo(httpClient, aVar, bool, bool2, interfaceC5074l, interfaceC4014c);
    }

    /* renamed from: sseSession-mY9Nd3A, reason: not valid java name */
    public static final Object m126sseSessionmY9Nd3A(HttpClient httpClient, String str, kotlin.time.a aVar, Boolean bool, Boolean bool2, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super ClientSSESession> interfaceC4014c) {
        return m102serverSentEventsSessionmY9Nd3A(httpClient, str, aVar, bool, bool2, interfaceC5074l, interfaceC4014c);
    }

    /* renamed from: sseSession-mY9Nd3A$default, reason: not valid java name */
    public static /* synthetic */ Object m128sseSessionmY9Nd3A$default(HttpClient httpClient, String str, kotlin.time.a aVar, Boolean bool, Boolean bool2, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            aVar = null;
        }
        if ((i10 & 4) != 0) {
            bool = null;
        }
        if ((i10 & 8) != 0) {
            bool2 = null;
        }
        if ((i10 & 16) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.client.plugins.sse.x
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return BuildersKt.sseSession_mY9Nd3A$lambda$11((HttpRequestBuilder) obj2);
                }
            };
        }
        return m126sseSessionmY9Nd3A(httpClient, str, aVar, bool, bool2, (InterfaceC5074l<? super HttpRequestBuilder, Y8.t>) interfaceC5074l, (InterfaceC4014c<? super ClientSSESession>) interfaceC4014c);
    }

    /* renamed from: sseSession-tL6_L-A, reason: not valid java name */
    public static final Object m130sseSessiontL6_LA(HttpClient httpClient, String str, String str2, Integer num, String str3, p9.p<? super TypeInfo, ? super String, ? extends Object> pVar, kotlin.time.a aVar, Boolean bool, Boolean bool2, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super ClientSSESessionWithDeserialization> interfaceC4014c) {
        return m106serverSentEventsSessiontL6_LA(httpClient, str, str2, num, str3, pVar, aVar, bool, bool2, interfaceC5074l, interfaceC4014c);
    }

    /* renamed from: sseSession-tL6_L-A$default, reason: not valid java name */
    public static /* synthetic */ Object m131sseSessiontL6_LA$default(HttpClient httpClient, String str, String str2, Integer num, String str3, p9.p pVar, kotlin.time.a aVar, Boolean bool, Boolean bool2, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        if ((i10 & 4) != 0) {
            num = null;
        }
        if ((i10 & 8) != 0) {
            str3 = null;
        }
        if ((i10 & 32) != 0) {
            aVar = null;
        }
        if ((i10 & 64) != 0) {
            bool = null;
        }
        if ((i10 & 128) != 0) {
            bool2 = null;
        }
        if ((i10 & 256) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.client.plugins.sse.v
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return BuildersKt.sseSession_tL6_L_A$lambda$23((HttpRequestBuilder) obj2);
                }
            };
        }
        return m130sseSessiontL6_LA(httpClient, str, str2, num, str3, pVar, aVar, bool, bool2, interfaceC5074l, interfaceC4014c);
    }

    /* renamed from: sseSession-xEWcMm4, reason: not valid java name */
    public static final Object m132sseSessionxEWcMm4(HttpClient httpClient, String str, String str2, Integer num, String str3, kotlin.time.a aVar, Boolean bool, Boolean bool2, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super ClientSSESession> interfaceC4014c) {
        return m108serverSentEventsSessionxEWcMm4(httpClient, str, str2, num, str3, aVar, bool, bool2, interfaceC5074l, interfaceC4014c);
    }

    /* renamed from: sseSession-xEWcMm4$default, reason: not valid java name */
    public static /* synthetic */ Object m133sseSessionxEWcMm4$default(HttpClient httpClient, String str, String str2, Integer num, String str3, kotlin.time.a aVar, Boolean bool, Boolean bool2, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        if ((i10 & 4) != 0) {
            num = null;
        }
        if ((i10 & 8) != 0) {
            str3 = null;
        }
        if ((i10 & 16) != 0) {
            aVar = null;
        }
        if ((i10 & 32) != 0) {
            bool = null;
        }
        if ((i10 & 64) != 0) {
            bool2 = null;
        }
        if ((i10 & 128) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.client.plugins.sse.u
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return BuildersKt.sseSession_xEWcMm4$lambda$10((HttpRequestBuilder) obj2);
                }
            };
        }
        return m132sseSessionxEWcMm4(httpClient, str, str2, num, str3, aVar, bool, bool2, interfaceC5074l, interfaceC4014c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t sseSession_Mswn__c$lambda$24(HttpRequestBuilder httpRequestBuilder) {
        kotlin.jvm.internal.p.i(httpRequestBuilder, "<this>");
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t sseSession_mY9Nd3A$lambda$11(HttpRequestBuilder httpRequestBuilder) {
        kotlin.jvm.internal.p.i(httpRequestBuilder, "<this>");
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t sseSession_tL6_L_A$lambda$23(HttpRequestBuilder httpRequestBuilder) {
        kotlin.jvm.internal.p.i(httpRequestBuilder, "<this>");
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t sseSession_xEWcMm4$lambda$10(HttpRequestBuilder httpRequestBuilder) {
        kotlin.jvm.internal.p.i(httpRequestBuilder, "<this>");
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t sse_BAHpl2s$lambda$25(HttpRequestBuilder httpRequestBuilder) {
        kotlin.jvm.internal.p.i(httpRequestBuilder, "<this>");
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t sse_Mswn__c$lambda$13(HttpRequestBuilder httpRequestBuilder) {
        kotlin.jvm.internal.p.i(httpRequestBuilder, "<this>");
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t sse_Q9yt8Vw$lambda$26(HttpRequestBuilder httpRequestBuilder) {
        kotlin.jvm.internal.p.i(httpRequestBuilder, "<this>");
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t sse_tL6_L_A$lambda$12(HttpRequestBuilder httpRequestBuilder) {
        kotlin.jvm.internal.p.i(httpRequestBuilder, "<this>");
        return Y8.t.f7040a;
    }

    /* renamed from: serverSentEventsSession-mY9Nd3A, reason: not valid java name */
    public static final Object m103serverSentEventsSessionmY9Nd3A(HttpClient httpClient, p9.p<? super TypeInfo, ? super String, ? extends Object> pVar, kotlin.time.a aVar, Boolean bool, Boolean bool2, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super ClientSSESessionWithDeserialization> interfaceC4014c) {
        HttpClientPluginKt.plugin(httpClient, SSEKt.getSSE());
        InterfaceC1083u interfaceC1083uC = C1087w.c(null, 1, null);
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        interfaceC5074l.invoke(httpRequestBuilder);
        addAttribute(httpRequestBuilder, sseRequestAttr, C4109a.a(true));
        addAttribute(httpRequestBuilder, reconnectionTimeAttr, aVar);
        addAttribute(httpRequestBuilder, showCommentEventsAttr, bool);
        addAttribute(httpRequestBuilder, showRetryEventsAttr, bool2);
        addAttribute(httpRequestBuilder, deserializerAttr, pVar);
        C1060i.d(httpClient, null, null, new BuildersKt$serverSentEventsSessionmY9Nd3A$$inlined$processSessionrp2poPw$1(new HttpStatement(httpRequestBuilder, httpClient), interfaceC1083uC, httpClient, null), 3, null);
        return interfaceC1083uC.a1(interfaceC4014c);
    }

    /* renamed from: sse-Mswn-_c, reason: not valid java name */
    public static final Object m113sseMswn_c(HttpClient httpClient, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, p9.p<? super TypeInfo, ? super String, ? extends Object> pVar, kotlin.time.a aVar, Boolean bool, Boolean bool2, p9.p<? super ClientSSESessionWithDeserialization, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> pVar2, InterfaceC4014c<? super Y8.t> interfaceC4014c) throws Throwable {
        Object objM92serverSentEventsMswn_c = m92serverSentEventsMswn_c(httpClient, interfaceC5074l, pVar, aVar, bool, bool2, pVar2, interfaceC4014c);
        return objM92serverSentEventsMswn_c == C4063a.g() ? objM92serverSentEventsMswn_c : Y8.t.f7040a;
    }

    /* renamed from: sseSession-mY9Nd3A, reason: not valid java name */
    public static final Object m127sseSessionmY9Nd3A(HttpClient httpClient, p9.p<? super TypeInfo, ? super String, ? extends Object> pVar, kotlin.time.a aVar, Boolean bool, Boolean bool2, InterfaceC5074l<? super HttpRequestBuilder, Y8.t> interfaceC5074l, InterfaceC4014c<? super ClientSSESessionWithDeserialization> interfaceC4014c) {
        return m103serverSentEventsSessionmY9Nd3A(httpClient, pVar, aVar, bool, bool2, interfaceC5074l, interfaceC4014c);
    }

    /* renamed from: serverSentEventsSession-mY9Nd3A$default, reason: not valid java name */
    public static /* synthetic */ Object m105serverSentEventsSessionmY9Nd3A$default(HttpClient httpClient, p9.p pVar, kotlin.time.a aVar, Boolean bool, Boolean bool2, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            aVar = null;
        }
        if ((i10 & 4) != 0) {
            bool = null;
        }
        if ((i10 & 8) != 0) {
            bool2 = null;
        }
        return m103serverSentEventsSessionmY9Nd3A(httpClient, (p9.p<? super TypeInfo, ? super String, ? extends Object>) pVar, aVar, bool, bool2, (InterfaceC5074l<? super HttpRequestBuilder, Y8.t>) interfaceC5074l, (InterfaceC4014c<? super ClientSSESessionWithDeserialization>) interfaceC4014c);
    }

    /* renamed from: sse-Mswn-_c$default, reason: not valid java name */
    public static /* synthetic */ Object m115sseMswn_c$default(HttpClient httpClient, InterfaceC5074l interfaceC5074l, p9.p pVar, kotlin.time.a aVar, Boolean bool, Boolean bool2, p9.p pVar2, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            aVar = null;
        }
        if ((i10 & 8) != 0) {
            bool = null;
        }
        if ((i10 & 16) != 0) {
            bool2 = null;
        }
        return m113sseMswn_c(httpClient, (InterfaceC5074l<? super HttpRequestBuilder, Y8.t>) interfaceC5074l, (p9.p<? super TypeInfo, ? super String, ? extends Object>) pVar, aVar, bool, bool2, (p9.p<? super ClientSSESessionWithDeserialization, ? super InterfaceC4014c<? super Y8.t>, ? extends Object>) pVar2, (InterfaceC4014c<? super Y8.t>) interfaceC4014c);
    }

    /* renamed from: sseSession-mY9Nd3A$default, reason: not valid java name */
    public static /* synthetic */ Object m129sseSessionmY9Nd3A$default(HttpClient httpClient, p9.p pVar, kotlin.time.a aVar, Boolean bool, Boolean bool2, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            aVar = null;
        }
        if ((i10 & 4) != 0) {
            bool = null;
        }
        if ((i10 & 8) != 0) {
            bool2 = null;
        }
        return m127sseSessionmY9Nd3A(httpClient, (p9.p<? super TypeInfo, ? super String, ? extends Object>) pVar, aVar, bool, bool2, (InterfaceC5074l<? super HttpRequestBuilder, Y8.t>) interfaceC5074l, (InterfaceC4014c<? super ClientSSESessionWithDeserialization>) interfaceC4014c);
    }
}
